package com.jk.service;

import com.jk.bean.Users;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider")
public interface LoginClientService {

    @RequestMapping("login")
    Users getLogins(Users users);

    @RequestMapping("addUsers")
    void toRegist(Users users);
    @RequestMapping("getloginAcct")
    Users getloginAcct(Users users);
}
