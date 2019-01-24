package com.jk.service.impl;

import com.jk.bean.QueryParam;
import com.jk.mapper.CarMapper;
import com.jk.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Resource
    private CarMapper carMapper;


    @Override
    public List<QueryParam> queryCar(String ids) {
        return carMapper.queryCar(ids);
    }
}
