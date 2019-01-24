package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Mall_product_comment;
import com.jk.bean.Users;
import com.jk.service.PlService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Controller
public class PlController {
 @Autowired
 PlService plService;
 @ResponseBody
 @RequestMapping("getPl")
 public SendPage getPl(ReceivePage rp, int id){
  return plService.getPl(rp,id);
 }
 @ResponseBody
 @RequestMapping("addPl")
 public String addPl(Mall_product_comment m, HttpSession session){
  Users user = (Users) session.getAttribute("user");
  if(user!=null){
   m.setYh_id(user.getId());
  }
  plService.addPl(m);
  return "1";
 }

}
