package com.jk.controller;

import com.jk.bean.Mall_Sku;
import com.jk.bean.Mall_attr;
import com.jk.bean.T_mall_trade_mark;
import com.jk.service.ProductShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/23
 * @since 1.0.0
 */
@Controller
public class ProductShowController {

    @Autowired
    ProductShowService productShowService;

    @ResponseBody
    @RequestMapping("getProductShow")
    public List<Mall_Sku> getProductShow(String id){
        List<Mall_Sku>list=productShowService.getProductShow(id);
       return list;
    }

    @ResponseBody
    @RequestMapping("getPinPai")
    public List<T_mall_trade_mark> getPinPai(Integer id){
        List<T_mall_trade_mark> list =  productShowService.getPinPai(id);
        return list;
    }

    @ResponseBody
    @RequestMapping("getAttrValue")
    public List<Mall_attr> getAttrValueName(Integer id){
        List<Mall_attr> list =  productShowService.getAttrValueName(id);
        return list;
    }




    @RequestMapping("getShowPage")
    public String getShowPage(String id, HttpSession session){
        Mall_Sku mall_Sku=  productShowService.getShowPage(id);
        session.setAttribute("mallSku",mall_Sku);
        return  "showPage";
    }
}
