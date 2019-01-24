package com.jk.service;

import com.jk.bean.QueryParam;

import java.util.List;

public interface CarService {

    List<QueryParam> queryCar(String ids);

}
