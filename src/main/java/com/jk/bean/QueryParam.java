package com.jk.bean;

import lombok.Data;

import java.io.Serializable;


@Data
public class QueryParam implements Serializable {


    //返回给前台的状态码
    private Integer code;

    private String loginAcct;//用户输入的账号
    private String phone_no;//发送验证码的手机号
    private String verify_code;//用户输入的验证码




}
