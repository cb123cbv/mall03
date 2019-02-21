package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Mall_product_comment;
import com.jk.mapper.PlMapper;
import com.jk.service.PlService;
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
 public void addPl(Mall_product_comment m) {
  plMapper.addPl(m);
 }

 //查询评论信息 评论页面的修改
 @Override
 public List<Mall_product_comment> getComment(Integer id) {
  return plMapper.getPl(id);
 }


}
