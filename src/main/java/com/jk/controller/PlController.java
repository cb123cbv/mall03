package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Mall_product_comment;
import com.jk.bean.Users;
import com.jk.service.PlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */
@Controller
public class PlController {
    @Autowired
    PlService plService;



    @ResponseBody
    @RequestMapping("addPl")
    public String addPl(Mall_product_comment m, HttpSession session) {
        Users user = (Users) session.getAttribute("users");
        if (user != null) {
            m.setYh_id(user.getId());
        }
        plService.addPl(m);
        return "1";
    }

    //查询评论信息 评论页面的修改
    @RequestMapping("getComment")
    @ResponseBody
    public List<Mall_product_comment> getComment(Integer id){
        List<Mall_product_comment> plList = plService.getComment(id);
        for (Mall_product_comment comment : plList) {
            System.out.println(comment);
        }
        return plList;
    }
}
