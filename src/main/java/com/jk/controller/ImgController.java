package com.jk.controller;


import com.jk.bean.ImgInfo;
import com.jk.bean.TitleInfo;
import com.jk.bean.TitleMin;
import com.jk.service.ImgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("img")
public class ImgController {

    @Resource
    private ImgService imgService;

    @RequestMapping("queryImg")
    @ResponseBody
    public List<ImgInfo> queryImg(){
        List<ImgInfo> list = imgService.queryImg();
      return list;
    }


    //查询标题
    @RequestMapping("queryTitle")
    @ResponseBody
    public List<TitleInfo> queryTitle(){
        List<TitleInfo> list = imgService.queryTitle();
        return list;
    }


    @RequestMapping("toView")
    public String toView(String url){

        return "test01";
    }

    //查询 滚动导航标题
    @RequestMapping("queryTitleMin")
    @ResponseBody
    public List<TitleMin> queryTitleMin(){
        List<TitleMin> list = imgService.queryTitleMin();
        return list;
    }


}
