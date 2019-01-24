package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/23
 * @since 1.0.0
 */
@Controller
@RequestMapping("test")
public class ViewController {

    @RequestMapping("test02")
    public String toView(String id, String id2, String name, String name2, Model model){
        model.addAttribute("name",name);
        model.addAttribute("name2",name2);
        return  "productShow";
    }



    @RequestMapping("toView")
    public String toView(String url){
        return url;
    }



}
