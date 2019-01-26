package com.jk.bean;

import lombok.Data;

@Data
public class Mall_shoppingCar_info {

    private Integer Id;//(编号)           PKInteger
    private String sku_mch;//(名称)      String
    private Integer sku_jg;//(sku价格)    Integer
    private String yh_xm;//(用户姓名)    String(100)
    private String yh_nch;//(用户昵称)   String
    private String yh_dz;//(用户地址)    String(100)
    private String shp_mch;//(商品名称)  String(100)
    private String shp_tp;//(商品图片)   String(100)
    private String sku_kc;//(sku库存)    Integer
    private String sku_shx;//(sku属性)   String(100)


}
