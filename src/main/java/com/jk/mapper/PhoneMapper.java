package com.jk.mapper;

import com.jk.bean.Phone;
import com.jk.bean.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PhoneMapper {


    @Select("select * from t_phonenum where pnumber=#{phone_no}")
    List<Phone> queryPhone(String phone_no);

    @Select("select * from t_user where loginAcct=#{loginAcct}")
    Users getloginAcct(String loginAcct);

}
