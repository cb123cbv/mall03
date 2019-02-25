package com.jk.mapper;


import com.jk.bean.ImgInfo;
import com.jk.bean.TitleInfo;
import com.jk.bean.TitleMin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ImgMapper {

    @Select("select * from t_imgInfo")
     List<ImgInfo> queryImg();

    @Select("select * from t_titleInfo")
    List<TitleInfo> queryTitle();

    //查询 滚动导航标题
    @Select("select * from t_title_min")
    List<TitleMin> queryTitleMin();
}
