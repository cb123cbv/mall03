package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Users;
import com.jk.service.LoginClientService;
import com.jk.utils.Contant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping("login")
public class LoginController {
    @Resource
    private LoginClientService loginClientService;

    @ResponseBody
    @RequestMapping("login")
    public String logins(Users users, Model Model , HttpServletResponse response) throws UnsupportedEncodingException {
        Users usersDb = loginClientService.getLogins(users);
        if (usersDb == null) {
            return "0";
        }
        //正确//判断有没有勾选记住密码
        if (users.getUser_pwd() != null) {
            //将Users对象转换成json字符串
            String jsonString = JSONObject.toJSONString(users);
            String encode = URLEncoder.encode(jsonString, "utf-8");
            Cookie cookie = new Cookie(Contant.remPwd, encode);
            //方法一
            //Cookie cookie = new Cookie(Contant.remPwd,users.getLoginAcct()+ Contant.splitChar+users.getUserPswd());
            cookie.setMaxAge(604800);
            cookie.setPath("/");
            //此时的cookie还在服务器上 要发送到浏览器上 通过响应对象
            response.addCookie(cookie);
        } else {
            //没有勾选--》清除密码
            Cookie cookie = new Cookie(Contant.remPwd, null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        Model.addAttribute("users", usersDb);

        return "1";
    }


    @RequestMapping("toLogin2")
    public String toLogin2(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Contant.remPwd)) {
                    String decode = URLDecoder.decode(cookie.getValue(), "utf-8");
                    Users users = JSONObject.parseObject(decode, Users.class);
                    model.addAttribute("username", users.getLoginAcct());
                    model.addAttribute("password", users.getUserPswd());

                }
            }

        }
        return "login";
    }

    @ResponseBody
    @RequestMapping("addUsers")
    public String addUsers(Users users) {
        if(StringUtils.isEmpty(users.getLoginAcct())&&StringUtils.isEmpty(users.getUserPswd())){
            return "0";
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
    public String toRegist() {

        return "regist";
    }

}
