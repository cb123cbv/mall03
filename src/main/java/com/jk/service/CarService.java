package com.jk.service;

import com.jk.bean.Mall_shoppingCar;
import com.jk.bean.Mall_shoppingCar_info;
import com.jk.bean.QueryParam;
import com.jk.bean.Users;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CarService {

    Mall_shoppingCar queryCar(Integer id);
    


    String judgeCookie2(String s, Cookie[] cookies);


    void addCarInfo(Users users, List<Mall_shoppingCar> shoppingCar);

    void addCarInfo2(Mall_shoppingCar car, Users users);

    List<Mall_shoppingCar> queryCarinfo();

    void updateCount(Integer id);
}
