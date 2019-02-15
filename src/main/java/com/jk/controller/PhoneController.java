package com.jk.controller;


import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Constant;
import com.jk.bean.Phone;
import com.jk.bean.QueryParam;
import com.jk.bean.Users;
import com.jk.service.LoginClientService;
import com.jk.service.PhoneService;
import com.jk.utils.Contant;
import com.jk.utils.HttpClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("phone")
public class PhoneController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private PhoneService phoneService;


    //手机发送验证码
    @ResponseBody
    @RequestMapping(value = "sendCode", produces = "application/json; charset=utf-8")
    public QueryParam sendCode(QueryParam queryParam,HttpSession session) {
        QueryParam qp = new QueryParam();
        List<Phone> phones = phoneService.queryPhone(queryParam.getPhone_no());
        if(phones.size()!=0){
            //在黑名单
            qp.setCode(5);
            return qp;
        }


        boolean code = redisTemplate.hasKey(Constant.phone_code+queryParam.getPhone_no());
        boolean multiple= redisTemplate.hasKey(Constant.multiple_code+queryParam.getPhone_no());
        if(code) {
            //如果为true说明状态码已存在,不让发送
            qp.setCode(2);

        }else {
            qp.setCode(1);
            Map<String, Object> params = new HashMap<>();

            // 产生一个4位验证码
            int r = (int) (Math.random() * 8999) + 1000;

            redisTemplate.opsForValue().set(Constant.phone_code+queryParam.getPhone_no(),r+"",1, TimeUnit.MINUTES);
            if (multiple) {

                int s = Integer.parseInt(redisTemplate.opsForValue().get(Constant.multiple_code + queryParam.getPhone_no()));
                if (s==3) {
                    //三次了,加入到黑名单
                    qp.setCode(4);
                    return qp;
                }else{
                    //登录次数+1
                    s=s+1;
                    redisTemplate.opsForValue().set(Constant.multiple_code+queryParam.getPhone_no(),s+"");//一天登录的次数
                }
            }else{
                //redisTemplate.opsForValue().increment(Constant.multiple_code+queryParam.getPhone_no(),1);//一天登录的次数
                redisTemplate.opsForValue().set(Constant.multiple_code+queryParam.getPhone_no(),1+"",1440,TimeUnit.MINUTES);
            }

            params.put("mobile", queryParam.getPhone_no());// 手机号 前台传过来的
            params.put("tpl_id", "124321");// 模板id
            params.put("tpl_value", "%23code%23%3d" + r);// 随机验证码
            params.put("key","99f52898ecf0854b4f9423446967770a");

            String result = HttpClient.sendGet("http://v.juhe.cn/sms/send",params);//返回的验证码
            session.setAttribute("yzm",r);
        }

        return qp;
    }


    @Resource
    private LoginClientService loginClientService;

    @ResponseBody
    @RequestMapping("login")
    public String logins(QueryParam queryParam){
        if(StringUtils.isEmpty(queryParam.getVerify_code())||StringUtils.isEmpty(queryParam.getLoginAcct())){
            return "2";
        }
        String s = redisTemplate.opsForValue().get(Constant.phone_code + queryParam.getPhone_no());
        if(!queryParam.getVerify_code().equals(s)){
            return "3";
        }


        Users usersDb = phoneService.getloginAcct(queryParam.getLoginAcct());
        if (usersDb == null) {
            return "0";
        }
        return "1";

    }







}
