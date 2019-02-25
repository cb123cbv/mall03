package com.jk.service;


import com.jk.bean.ImgInfo;
import com.jk.bean.TitleInfo;
import com.jk.bean.TitleMin;

import java.util.List;

public interface ImgService {
    List<ImgInfo> queryImg();

    List<TitleInfo> queryTitle();

    //查询 滚动导航标题
    List<TitleMin> queryTitleMin();
}
