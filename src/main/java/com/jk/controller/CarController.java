package com.jk.controller;

import com.jk.bean.Constant;
import com.jk.bean.Mall_shoppingCar;
import com.jk.bean.Users;
import com.jk.service.CarService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("car")
public class CarController {


    @Resource
    private CarService carService;
    @Resource
    private RedisTemplate<String, List<Mall_shoppingCar>> redisTemplate;

    //加入购物车
    @ResponseBody
    @RequestMapping("addCar")//HttpServletRequest取cookie,HttpServletResponse存cookie
    public String queryCookie(Integer sku,HttpServletRequest request, HttpServletResponse response, HttpSession session,Integer sl) {
        Cookie[] cookies = request.getCookies();
        String s = carService.judgeCookie2(Constant.uuid, cookies);
        Users users = (Users) session.getAttribute("users");

        //用户已登录
        if (users != null) {
            Mall_shoppingCar car = carService.queryCar(sku);

            //有值,遍历,看时候有重复
            List<Mall_shoppingCar> mall_shoppingCars = carService.queryCarinfo(users.getId());
            if (mall_shoppingCars.size()>0) {
                Integer num = 0;
                for (Mall_shoppingCar cars : mall_shoppingCars) {
                    if (cars.getSku_id().equals(sku)) {
                        //cars.setTjshl(car.getTjshl() + 1);
                        carService.updateCount(cars.getId(),sl);
                        num = 1;
                    }
                }
                if (num != 1) {
                    Mall_shoppingCar cars = carService.queryCar(sku);
                    cars.setTjshl(sl);
                    carService.addCarInfo2(cars,users);
                }
            }else{
                //数据库中,没有购物商品
                Mall_shoppingCar cars = carService.queryCar(sku);
                cars.setTjshl(sl);
                carService.addCarInfo2(cars,users);

            }


            redisTemplate.delete(Constant.redis_List+users.getId());
        }


        //用户未登录
        if (users == null) {
            if (s.equals("2")) {//购物车上没有数据,去后台查询添`加到redis
                Mall_shoppingCar car = carService.queryCar(sku);
                car.setTjshl(sl);
                Cookie newcookie = new Cookie(Constant.uuid, "sssssss");//在存进去
                newcookie.setMaxAge(7200);//保存两个小时
                newcookie.setPath("/");
                //此时的cookie还在服务器上 要发送到浏览器上 通过响应对象
                response.addCookie(newcookie);
                //redisTemplate.delete();
                ArrayList<Mall_shoppingCar> cars = new ArrayList<>();
                cars.add(car);
                //将数据放入redis里
                redisTemplate.opsForValue().set(Constant.uuid, cars, 120, TimeUnit.MINUTES);
            } else {
                Cookie newcookie = new Cookie(Constant.uuid, "sssssss");//在存进去
                newcookie.setMaxAge(7200);//保存两个小时
                newcookie.setPath("/");
                //此时的cookie还在服务器上 要发送到浏览器上 通过响应对象
                response.addCookie(newcookie);

                //有值,遍历,看时候有重复
                List<Mall_shoppingCar> cars = redisTemplate.opsForValue().get(Constant.uuid);
                Integer num = 0;
                for (Mall_shoppingCar car : cars) {
                    if (car.getSku_id().equals(sku)) {
                        car.setTjshl(car.getTjshl() + sl);
                        num = 1;
                    }
                }
                if (num != 1) {
                    Mall_shoppingCar car = carService.queryCar(sku);
                    car.setTjshl(sl);
                    cars.add(car);
                }
                redisTemplate.opsForValue().set(Constant.uuid, cars, 120, TimeUnit.MINUTES);
            }
        }


        return "1";
    }


    //查看购物车
    @ResponseBody
    @RequestMapping("queryCar")//HttpServletRequest取cookie,HttpServletResponse存cookie
    public List<Mall_shoppingCar> queryCar(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        List<Mall_shoppingCar> shoppingCar = null;
        Cookie[] cookies = request.getCookies();
        //用户登录,查询cookie,把缓存中的东西添加在数据库
        Users users = (Users) session.getAttribute("users");

        //以登录,点击查看购物车,存入数据库中
        if (users != null) {
            String s = carService.judgeCookie2(Constant.uuid, cookies);
            if (s.equals("1")) {
                Boolean exis = redisTemplate.hasKey(Constant.uuid);
                if (exis) {
                    shoppingCar = redisTemplate.opsForValue().get(Constant.uuid);
                    carService.addCarInfo(users, shoppingCar);
                    redisTemplate.delete(Constant.uuid);
                    Cookie newcookie = new Cookie(Constant.uuid, "sssssss");//在存进去
                    newcookie.setMaxAge(0);
                    newcookie.setPath("/");
                    response.addCookie(newcookie);
                }
            }

            //以登录,点击查看购物车,查看缓存
            Boolean exiskey = redisTemplate.hasKey(Constant.redis_List+users.getId());//存在账号,查看redis中是否存在数据
            if (exiskey) {
                shoppingCar = redisTemplate.opsForValue().get(Constant.redis_List+users.getId());
            }else{
                List<Mall_shoppingCar> mall_shoppingCars = carService.queryCarinfo(users.getId());
                redisTemplate.opsForValue().set(Constant.redis_List+users.getId(), mall_shoppingCars, 120, TimeUnit.MINUTES);
                return mall_shoppingCars;
            }


        }

        //未登录
        if (users == null) {
            String s = carService.judgeCookie2(Constant.uuid, cookies);
            if (s.equals("1")) {
                Boolean exiskey = redisTemplate.hasKey(Constant.uuid);//存在账号,查看redis中是否存在数据
                if (exiskey) {
                    shoppingCar = redisTemplate.opsForValue().get(Constant.uuid);
                } else {
                    shoppingCar = null;
                }

            } else {
                shoppingCar = null;
            }
        }

        return shoppingCar;
    }
    /*删除商品*/
    @ResponseBody
    @RequestMapping("deleteCartProduct")
    public String deleteCartProduct(Integer sku_id,HttpSession session){
        Users users = (Users) session.getAttribute("users");
        if(users!=null){
            carService.deleteCartProduct(sku_id,users.getId());
            /*List<Mall_shoppingCar> carList = redisTemplate.opsForValue().get(Constant.redis_List + users.getId());
            for (Mall_shoppingCar car : carList) {
                if(car.getSku_id().equals(sku_id)&&car.getYh_id().equals(users.getId())){
                    carList.remove(car);
                }
                if(carList.size()==0){
                    break;
                }
            }
            if(carList.size()==0){
                redisTemplate.delete(Constant.redis_List+users.getId());
            }else{
                redisTemplate.opsForValue().set(Constant.redis_List+users.getId(),carList);
            }*/
            redisTemplate.delete(Constant.redis_List+users.getId());
        }else{
            String key = Constant.uuid;
            List<Mall_shoppingCar> shoppingCars = redisTemplate.opsForValue().get(key);
            for (Mall_shoppingCar shoppingCar : shoppingCars) {
                if(shoppingCar.getSku_id().equals(sku_id)){
                    shoppingCars.remove(shoppingCar);
                }
                if(shoppingCars.size()==0){
                    break;
                }
            }
            if(shoppingCars.size()==0){
                redisTemplate.delete(key);
            }else{
                redisTemplate.opsForValue().set(key,shoppingCars,120, TimeUnit.MINUTES);
            }
        }
        return "1";
    }
    /*修改购物车数量*/
    @ResponseBody
    @RequestMapping("updateCartProduct")
    public String updateCartProduct(Integer sl,Integer sku_id,HttpSession session){
        Users users = (Users) session.getAttribute("users");
        /*登陆状态*/
        if(users!=null){
            carService.updateCartProduct(sl,sku_id,users.getId());
            redisTemplate.delete(Constant.redis_List+users.getId());
        }
        /*未登陆状态*/
        else{
            List<Mall_shoppingCar> cars = redisTemplate.opsForValue().get(Constant.uuid);
            for (Mall_shoppingCar car : cars) {
                if(car.getSku_id().equals(sku_id)){
                    car.setTjshl(sl);
                }
            }
            redisTemplate.opsForValue().set(Constant.uuid,cars,120, TimeUnit.MINUTES);
        }
        return "1";
    }
}
