package com.jk.service;

import com.jk.bean.Mall_product_comment;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface PlService {
 SendPage getPl(ReceivePage rp, int id);

 void addPl(Mall_product_comment m);
}
