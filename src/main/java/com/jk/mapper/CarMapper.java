package com.jk.mapper;

import com.jk.bean.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {


    List<QueryParam> queryCar(@Param("ids") String ids);

}
