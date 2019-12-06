package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.Movie;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MovieMapper {

    @InsertProvider(type = MovieProvider.class, method = "insert")
    void insert(@Param("movie") Movie movie);

}
