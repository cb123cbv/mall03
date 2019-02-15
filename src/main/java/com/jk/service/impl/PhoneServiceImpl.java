package com.jk.service.impl;

import com.jk.bean.Phone;
import com.jk.bean.Users;
import com.jk.mapper.PhoneMapper;
import com.jk.service.PhoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Resource
    private PhoneMapper phoneMapper;

    @Override
    public List<Phone> queryPhone(String phone_no) {
        return phoneMapper.queryPhone(phone_no);
    }

    @Override
    public Users getloginAcct(String loginAcct) {
        return phoneMapper.getloginAcct(loginAcct);
    }
}
