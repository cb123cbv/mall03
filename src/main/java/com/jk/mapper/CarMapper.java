package com.jk.mapper;

import com.jk.bean.Mall_shoppingCar;
import com.jk.bean.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarMapper {


    Mall_shoppingCar queryCar(Integer id);

    void addCarInfo(@Param("car")Mall_shoppingCar car, @Param("users")Users users);


    @Select("select * from t_mall_shoppingcar where yh_id= #{userid}")
    List<Mall_shoppingCar> queryCarinfo(@Param("userid")Integer userid);

    void updateCount(@Param("id")Integer id, @Param("sl")Integer sl);


}
