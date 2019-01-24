package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.github.pagehelper.PageHelper;
import com.jk.bean.Mall_product_comment;
import com.jk.mapper.PlMapper;
import com.jk.service.PlService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class PlServiceImpl implements PlService {
 @Autowired
 PlMapper plMapper;
 @Override
 public SendPage getPl(ReceivePage rp, int id) {
  List<Mall_product_comment> count =plMapper.getPl(id);
  int pageNow=rp.getOffset()/rp.getPageSize()+1;
  PageHelper.startPage(pageNow,rp.getPageSize());
  List<Mall_product_comment> list =plMapper.getPl(id);
  SendPage sp=new SendPage(count.size(),list);
  return sp;
 }

 @Override
 public void addPl(Mall_product_comment m) {
  plMapper.addPl(m);
 }


}
