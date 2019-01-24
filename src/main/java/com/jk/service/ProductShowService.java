package com.jk.service;

import com.jk.bean.Mall_Sku;
import com.jk.bean.Mall_attr;
import com.jk.bean.T_mall_trade_mark;

import java.util.List;

public interface ProductShowService {

    List<Mall_Sku> getProductShow(String id);

    List<T_mall_trade_mark> getPinPai(Integer id);

    List<Mall_attr> getAttrValueName(Integer id);
}
