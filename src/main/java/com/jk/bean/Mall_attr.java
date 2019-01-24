package com.jk.bean;

import lombok.Data;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/23
 * @since 1.0.0
 */
@Data
public class Mall_attr {
    Integer id;
    String shxm_mch;
    String shfqy;
    Integer flbh2;
    String chjshj;
    List<String> shuxzhlist;
}
