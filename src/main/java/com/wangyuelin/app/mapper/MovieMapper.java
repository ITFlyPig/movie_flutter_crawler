package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.Movie;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.type.JdbcType;

@CacheNamespace(eviction = LruCache.class, flushInterval = 60000L, size = 1024, readWrite = true)
@Mapper
public interface MovieMapper {

    @InsertProvider(type = MovieProvider.class, method = "insert")
    void insert(@Param("movie") Movie movie);


    @SelectProvider(type = MovieProvider.class, method = "getById")
    @Results(id = "movieResult", value = {
            @Result(property = "id", column = "id", id = true, javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "actorsStr", column = "actors", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    Movie getById(@Param("id") long id);

    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 60000)
    @Select("SELECT * FROM movie WHERE name LIKE #{name} LIMIT 1")
    @ResultMap(value = "movieResult")
    Movie getByName(@Param("name") String name);

    @Select("SELECT id FROM movie WHERE name LIKE #{name} LIMIT 1")
    long getIdByName(@Param("name") String name);
}
