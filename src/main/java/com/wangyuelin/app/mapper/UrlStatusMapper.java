package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.UrlStatus;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

@CacheNamespace(eviction = LruCache.class, flushInterval = 60000L, size = 1024, readWrite = true)
@Mapper
public interface UrlStatusMapper {

    /**
     * 记录url的爬取情况
     * @param url
     * @param status
     * @return
     */
    @Insert("INSERT INTO url_status(url, status) VALUES(#{url}, #{status})")
    void insert(@Param("url") String url, @Param("status") int status);

    /**
     * 查询一条url的状态
     * @param url
     * @return
     */
    @Select("SELECT status FROM url_status WHERE url LIKE #{url}")
    Integer getUrlStatus(@Param("url") String url);

    /**
     * 查询所有的url状态
     * @return
     */
    @Select("SELECT * FROM url_status")
    @Results({
            @Result(property = "id", column = "id", id = true, javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "url", column = "url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "status", column = "status", id = true, javaType = Integer.class, jdbcType = JdbcType.BIGINT)
    })
    List<UrlStatus> getAllUrlStatus();

    /**
     * 更新一条url的状态
     * @param url
     * @param status
     */
    @Update("UPDATE url_status SET status = #{status} WHERE url LIKE #{url}")
    void updateStatus(@Param("url") String url,@Param("status") int status);




}
