package com.jk.mapper;

import com.jk.bean.Attr_value;
import com.jk.bean.Mall_Sku;
import com.jk.bean.Mall_attr;
import com.jk.bean.T_mall_trade_mark;

import java.util.List;

public interface ProductShowMapper {


    List<Mall_Sku> getProductShow(String id);

    List<T_mall_trade_mark> getPinPai(Integer id);

    List<Mall_attr> getAttrValueName(Integer id);

    List<Attr_value> getAttrValue(Integer id);

    Mall_Sku getShowPage(String id);
}
