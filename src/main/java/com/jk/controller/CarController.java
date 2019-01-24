package com.jk.controller;

import com.jk.bean.Constant;
import com.jk.bean.QueryParam;
import com.jk.service.CarService;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("car")
public class CarController {

    @Resource
    private CarService carService;
    @Resource
    private RedisTemplate<String, List<QueryParam>> redisTemplate;


    //sku存入cookie
    @ResponseBody
    @RequestMapping("queryCookie")//HttpServletRequest取cookie,HttpServletResponse存cookie
    public String queryCookie(String sku, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            //不存在创建一个购物车的cookie
            Cookie newcookie = new Cookie(Constant.car_cookie, sku);
            newcookie.setMaxAge(7200);//保存两个小时
            newcookie.setPath("/");
            //此时的cookie还在服务器上 要发送到浏览器上 通过响应对象
            response.addCookie(newcookie);

        }

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //判断购物车的cookie是否存在
                if (cookie.getName().equals(Constant.car_cookie)) {//存在,把sku存进去
                    String carList = cookie.getValue() + Constant.car_joint + sku;//把值取出来
                    Cookie newcookie = new Cookie(Constant.car_cookie, carList);//在存进去
                    newcookie.setMaxAge(7200);//保存两个小时
                    newcookie.setPath("/");
                    //此时的cookie还在服务器上 要发送到浏览器上 通过响应对象
                    response.addCookie(newcookie);
                    return "1";
                }
            }
            //不存在创建一个购物车的cookie
            Cookie newcookie = new Cookie(Constant.car_cookie, sku);
            newcookie.setMaxAge(7200);//保存两个小时
            newcookie.setPath("/");
            //此时的cookie还在服务器上 要发送到浏览器上 通过响应对象
            response.addCookie(newcookie);

        }
        return "1";
    }


    //查看购物车
    @ResponseBody
    @RequestMapping("queryCar")//HttpServletRequest取cookie,HttpServletResponse存cookie
    public List<QueryParam> queryCar(HttpServletRequest request) {
        List<QueryParam> queryParams=null;

        Boolean exiskey = redisTemplate.hasKey(Constant.redis_List);
        if (exiskey) {// 内存里有tree数据
            // 内存中有树的数据 取出数据
            queryParams = redisTemplate.opsForValue().get(Constant.redis_List);
        } else {// 内存中没有树的数据

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(Constant.car_cookie)) {//把cookie取出来
                        String[] cookieList = cookie.getValue().split(Constant.car_joint);
                        String flag="";
                        for (String s : cookieList) {
                            flag+=","+s;
                        }
                        String ids = flag.substring(1);
                        queryParams = carService.queryCar(ids);
                        redisTemplate.opsForValue().set(Constant.redis_List, queryParams, 20, TimeUnit.MINUTES);

                    }
                }
                return queryParams;
            }
        }
            return queryParams;
    }











}


