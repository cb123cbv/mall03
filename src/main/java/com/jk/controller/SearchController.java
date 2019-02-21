package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Mall_Sp;
import com.jk.service.SearchClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class SearchController {
 @Autowired
 SearchClientService searchClientService;
 @RequestMapping("queryProduct")
 public List<Mall_Sp>  queryProduct(@RequestParam(value = "queryString")String queryString){
  List<Mall_Sp> sku = searchClientService.getSku(queryString);
  return sku;
 }
}
