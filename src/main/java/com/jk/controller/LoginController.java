package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Users;
import com.jk.service.LoginClientService;
import com.jk.utils.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping("login")
public class LoginController {
    @Resource
    private LoginClientService loginClientService;

    @Autowired
    private JavaMailSender sender;

    @ResponseBody
    @RequestMapping("login")
    public String logins(Users users, HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {
        Users usersDb = loginClientService.getLogins(users);
        if (usersDb == null) {
            return "0";
        }
        //正确//判断有没有勾选记住密码
        if (users.getUser_pwd() != null) {
            //将Users对象转换成json字符串
            String jsonString = JSONObject.toJSONString(usersDb);
            String encode = URLEncoder.encode(jsonString, "utf-8");
            Cookie cookie = new Cookie(Contant.remPwd, encode);

            //方法一
            Cookie cookie1 = new Cookie(Contant.remPwdr,usersDb.getLoginAcct()+ Contant.splitChar+usersDb.getUserName());
            cookie.setMaxAge(604800);
            cookie1.setMaxAge(604800);
            cookie.setPath("/");
            cookie1.setPath("/");
            //此时的cookie还在服务器上 要发送到浏览器上 通过响应对象
            response.addCookie(cookie);
            response.addCookie(cookie1);
        } else {
            //没有勾选--》清除密码
            Cookie cookie = new Cookie(Contant.remPwd, null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        if(users.getLoginZd()!=null) {
            Cookie cookie2 = new Cookie(Contant.zddl, users.getLoginZd());
            cookie2.setMaxAge(604800);
            cookie2.setPath("/");
            response.addCookie(cookie2);
        }else{
            Cookie cookie2 = new Cookie(Contant.zddl,null);
            cookie2.setMaxAge(0);
            cookie2.setPath("/");
            response.addCookie(cookie2);
        }
        session.setAttribute("users", usersDb);
        return "1";
    }


    @RequestMapping("toLogin2")
    public String toLogin2(HttpServletRequest request,HttpSession session, Model model) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Contant.remPwd)) {
                    String decode = URLDecoder.decode(cookie.getValue(), "utf-8");
                    Users users = JSONObject.parseObject(decode, Users.class);
                    model.addAttribute("username", users.getLoginAcct());
                    model.addAttribute("password", users.getUserPswd());
                    session.setAttribute("name", users);
            }
                if (cookie.getName().equals(Contant.zddl)) {
                    String decode2 = URLDecoder.decode(cookie.getValue(), "utf-8");
                    System.out.println(decode2);
                    model.addAttribute("decode2", decode2);
            }else{
                    model.addAttribute("decode2", null);
                }
            }

        }

        return "login";
    }


    @RequestMapping("sendSimpleMail")
    @ResponseBody
    public String sendSimpleMail(String email,HttpSession session){
        if(StringUtils.isEmpty(email)){
            return "2";
        }
        SimpleMailMessage message = new SimpleMailMessage();
        // 产生一个4位验证码
        int r = (int) (Math.random() * 8999) + 1000;
        message.setFrom("zhang1009603379@163.com"); // 必须要和上文配置的spring.mail.username内容相同
        message.setTo(email);
        message.setSubject("注册");
        message.setText(r+"");
        sender.send(message);
        session.setAttribute("yzm2",r+"");
        return "1";
    }





    @ResponseBody
    @RequestMapping("addUsers")
    public String addUsers(Users users,String code,HttpSession session) {
        if(StringUtils.isEmpty(users.getLoginAcct())||StringUtils.isEmpty(users.getUserPswd())){
            return "0";
        }
        if(StringUtils.isEmpty(users.getEmail())){
            return "3";
        }
        if(StringUtils.isEmpty(code)){
            return "4";
        }
        String yzm2 = (String) session.getAttribute("yzm2");
        if(!code.equals(yzm2)){
            return "5";
        }

        Users usersDb = loginClientService.getloginAcct(users);
        if (usersDb != null) {
            if (usersDb.getLoginAcct().equals(users.getLoginAcct())) {
                return "2";
            }
        }
        loginClientService.toRegist(users);
            return "1";

    }

    @RequestMapping("toRegist")
    public String toRegist(HttpServletResponse response) {

        Cookie cookie = new Cookie(Contant.remPwd, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "regist";
    }

}
