package com.jk.service;


import com.jk.bean.ImgInfo;
import com.jk.bean.TitleInfo;

import java.util.List;

public interface ImgService {
    List<ImgInfo> queryImg();

    List<TitleInfo> queryTitle();
}
