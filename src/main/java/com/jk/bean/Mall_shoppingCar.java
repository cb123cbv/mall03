package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Mall_shoppingCar implements Serializable{

    private Integer id;//(编号)          PKInteger
    private String sku_mch;//(sku名称)  String(100)//
    private Integer sku_jg;//(sku价格)   decimal//
    private Integer tjshl;//(添加数量)   Integer
    private Integer hj;//(合计)          decimal--
    private Integer yh_id=-1;//(用户id)     Integer//--
    private Integer shp_id;//(商品id)    Integer//--
    private Date chjshj;//(创建时间)  Date
    private Integer sku_id;//(skuid)     Integer//--
    private String shp_tp;//(商品图片)  String(100)//
    private Integer shfxz=1;//(是否选中)   String(1)--
    private String kcdz;//(库存地址) String(500)//


}
