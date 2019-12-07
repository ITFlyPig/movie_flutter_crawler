package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.Movie;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface MovieMapper {

    @InsertProvider(type = MovieProvider.class, method = "insert")
    void insert(@Param("movie") Movie movie);



    @SelectProvider(type = MovieProvider.class, method = "getById")
    @Results( {
            @Result(property = "id", column = "id", id = true, javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "actorsStr", column = "actors", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    Movie getById(@Param("id") long id);

}
