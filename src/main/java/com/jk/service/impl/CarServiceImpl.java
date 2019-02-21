package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.CarMapper;
import com.jk.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Resource
    private CarMapper carMapper;


    @Override
    public Mall_shoppingCar queryCar(Integer id) {

        return carMapper.queryCar(id);
    }


    //判断cookie里的name是否存在,存在返回true,不存在返回false
    @Override
    public String judgeCookie2(String s, Cookie[] cookies) {
        String flag = "";
        for (Cookie cookie : cookies) {
            //看现在是否登录,未登录有名字
            if (cookie.getName().equals(s)) {
                flag ="1";
            } else {
                flag ="2";
            }
        }
        return flag;
    }

    //向数据库存入购物车
    @Override
    public void addCarInfo(Users users, List<Mall_shoppingCar> shoppingCar) {
        List<Mall_shoppingCar> carList = carMapper.queryCarinfo(users.getId());
        if (carList.size()>0) {//如果数据库中的购物车有数据,将redis中的数据和数据库购物车
            for (Mall_shoppingCar car : shoppingCar) {
                for (Mall_shoppingCar car2 : carList) {
                    if(car.getSku_id().equals(car2.getSku_id())){
                        carMapper.updateCount(car2.getId(),car2.getTjshl());
                        car.setSku_mch("hhh");
                    }
                }
            }

            for (Mall_shoppingCar mall_shoppingCar : shoppingCar) {
                if(!mall_shoppingCar.getSku_mch().equals("hhh")){
                    carMapper.addCarInfo(mall_shoppingCar,users);
                }
            }
        }else{//如果数据库中的购物车没有数据

            for (Mall_shoppingCar mall_shoppingCar : shoppingCar) {
                carMapper.addCarInfo(mall_shoppingCar,users);
            }

        }


    }

    //登录成功后,加入购物车
    @Override
    public void addCarInfo2(Mall_shoppingCar car, Users users) {
        //car.setHj((car.getSku_jg())*(car.getTjshl()));
        carMapper.addCarInfo(car,users);
    }

    @Override
    public List<Mall_shoppingCar> queryCarinfo(Integer userid) {
        return carMapper.queryCarinfo(userid);
    }

    @Override
    public void updateCount(Integer id, Integer sl) {
        carMapper.updateCount(id,sl);
    }



    /*//购物车cookie存在,存sku
    @Override
    public void updateCookie(String s, Cookie[] cookies, String sku, HttpServletResponse response) {
        for (Cookie cookie : cookies) {
            //判断购物车的cookie是否存在
            if (cookie.getName().equals(s)) {//存在,把sku存进去
                String carList = cookie.getValue() + Constant.car_joint + sku;//把值取出来
                Cookie newcookie = new Cookie(s, carList);//在存进去
                newcookie.setMaxAge(7200);//保存两个小时
                newcookie.setPath("/");
                //此时的cookie还在服务器上 要发送到浏览器上 通过响应对象
                response.addCookie(newcookie);
                //redisTemplate.delete();
            }
        }
    }

    @Override//不存za创建一个存放sku的cookie
    public void setCookie(String s, String sku, HttpServletResponse response) {
        Cookie newcookie = new Cookie(s, sku);
        newcookie.setMaxAge(7200);//保存两个小时
        newcookie.setPath("/");
        //此时的cookie还在服务器上 要发送到浏览器上 通过响应对象
        response.addCookie(newcookie);
    }


  *//*  //向数据库存入购物车
    @Override
    public void addCarInfo(String sku, Users users) {
        List<QueryParam> carinfo = carMapper.queryCar(sku);
        for (QueryParam queryParam : carinfo) {
            carMapper.addCarInfo(queryParam.getId()+"",users);
        }
    }*//*

    //把cookie中的sku添加进数据库
    @Override
    public void addsCar(Users users, String[] cookieList) {
        for (String s : cookieList) {
            carMapper.addCarInfo(s,users);
        }
    }

    @Override//查询数据库购物车
    public List<Mall_shoppingCar_info> queryCarinfo() {

        return carMapper.queryCarinfo();
    }*/


}