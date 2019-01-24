package com.jk.bean;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/23
 * @since 1.0.0
 */
@Data
public class  Mall_Sku {
    Integer   id;               //(编号)          PKInteger
    Integer   shp_id;          //(商品id)      Integer
    Integer   kc;               //(库存)          Integer
    Double    jg;              //(价格)          decimal
    String    chjshj;           //(创建时间)  Date
    String    sku_mch;          //(sku名称)  String(100)
    Integer   sku_xl;           //(sku销量)   Integer
    String    kcdz;             //(库存地址)    String(500)


    private  String shpmch;     //商品名称
    private  String shxmmch;    //属性
    private  String shxzhmch;   //属性值名
    private  String sxz;         //属性值
    private  String adress;      //仓库地址
    private  String img;         //图片
    private  String price;       //价格
    private  String msh;         //描述

}
