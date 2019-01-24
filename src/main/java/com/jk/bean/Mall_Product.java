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
public class Mall_Product {
    Integer Id;          //(编号)           PKInteger
    String  shp_mch;     //(商品名称)  String(100)
    String  shp_tp;      //(商品图片)   String(100)
    Integer  flbh1;      //(分类编号1)   Integer
    Integer  flbh2;      //(分类编号2)   Integer
    Integer  pp_id;      //(品牌id)      Integer
    String   chjshj;     //(创建时间)   Date
    String   shp_msh;    //(商品描述)  String(1000)
}
