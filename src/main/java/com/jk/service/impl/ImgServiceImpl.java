package com.jk.service.impl;

import com.jk.bean.ImgInfo;
import com.jk.bean.TitleInfo;
import com.jk.bean.TitleMin;
import com.jk.mapper.ImgMapper;

import com.jk.service.ImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {

    @Resource
    private ImgMapper imgMapper;

    @Override
    public List<ImgInfo> queryImg() {

      return  imgMapper.queryImg();
    }

    @Override
    public List<TitleInfo> queryTitle() {
        return imgMapper.queryTitle();
    }

    //查询 滚动导航标题
    @Override
    public List<TitleMin> queryTitleMin() {
        return imgMapper.queryTitleMin();
    }

}
