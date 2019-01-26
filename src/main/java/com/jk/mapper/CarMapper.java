package com.jk.mapper;

import com.jk.bean.Mall_shoppingCar;
import com.jk.bean.Mall_shoppingCar_info;
import com.jk.bean.QueryParam;
import com.jk.bean.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarMapper {


    Mall_shoppingCar queryCar(Integer id);

    void addCarInfo(@Param("car")Mall_shoppingCar car, @Param("users")Users users);

    @Select("select * from t_mall_shoppingcar")
    List<Mall_shoppingCar> queryCarinfo();

    void updateCount(Integer id);


}
