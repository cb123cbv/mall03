package com.jk.bean;

import lombok.Data;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/23
 * @since 1.0.0
 */
@Data
public class Attr_value {
    private Integer id;//(编号)  PKInteger
    private String shxzh;//(属性值) String(100)
    private String shfqy;//(是否启用)  String(1)
    private Integer shxm_id;//(属性id)  Integer
    private String shxzh_mch;//(单位) String(100)
    private String chjshj;//(创建时间) Date
    private String shxm;//(属性名) String(100)
}
