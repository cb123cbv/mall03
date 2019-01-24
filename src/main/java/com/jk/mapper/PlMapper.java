package com.jk.mapper;

import com.jk.bean.Mall_product_comment;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface PlMapper {
 List<Mall_product_comment> getPl(int id);

 void addPl(Mall_product_comment m);
}
