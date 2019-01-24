package com.jk.service.impl;

import com.jk.bean.Attr_value;
import com.jk.bean.Mall_Sku;
import com.jk.bean.Mall_attr;
import com.jk.bean.T_mall_trade_mark;
import com.jk.mapper.ProductShowMapper;
import com.jk.service.ProductShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/23
 * @since 1.0.0
 */
@Service
public class ProductShowServiceImpl implements ProductShowService {

    @Resource
    ProductShowMapper productShowMapper;


    @Override
    public List<Mall_Sku> getProductShow(String id) {

        return productShowMapper.getProductShow(id);
    }

    @Override
    public List<T_mall_trade_mark> getPinPai(Integer id) {
        return productShowMapper.getPinPai(id);
    }

    @Override
    public List<Mall_attr> getAttrValueName(Integer id) {
        List<Mall_attr> list1 = productShowMapper.getAttrValueName(id);
        for (Mall_attr mall_attr : list1) {
            List<String> aaa = new ArrayList<>();
            List<Attr_value> list2 = productShowMapper.getAttrValue(mall_attr.getId());
            for (Attr_value attr_value : list2) {
                aaa.add(attr_value.getShxzh());
            }
            mall_attr.setShuxzhlist(aaa);
        }
        return list1;
    }

    @Override
    public Mall_Sku getShowPage(String id) {

        return productShowMapper.getShowPage(id);
    }
}
