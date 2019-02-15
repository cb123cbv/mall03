package com.jk.service;

import com.jk.bean.Phone;
import com.jk.bean.Users;

import java.util.List;

public interface PhoneService {
    List<Phone> queryPhone(String phone_no);


    Users getloginAcct(String loginAcct);
}
