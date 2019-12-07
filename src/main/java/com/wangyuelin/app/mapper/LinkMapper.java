package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.MovieLink;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@CacheNamespace(eviction = LruCache.class, flushInterval = 60000L, size = 1024, readWrite = true)
@Mapper
public interface LinkMapper {

    /**
     * 记录某个电影 都有那种类型的资源
     * @param linkType
     * @param from
     * @param movieId
     */
    @Insert("INSERT INTO movie_link(link_type, `from`, movie_id) VALUES(#{linkType}, #{from}, #{movieId})")
    void insertLink(@Param("linkType") int linkType, @Param("from") String from, @Param("movieId") long movieId);

    /**
     * 查询某个电影的特定类型的资源是否存在
     * @param linkType
     * @param from
     * @param movieId
     * @return
     */
    @Select("SELECT id FROM movie_link WHERE link_type = #{linkType} AND `from` = #{from} AND movie_id = #{movieId} LIMIT 1")
    Integer getLinkId(@Param("linkType") int linkType, @Param("from") String from, @Param("movieId") long movieId);

    /**
     * 真正记录下载或者播放链接
     * @param name
     * @param link
     * @param movieLinkId
     */
    @Insert("INSERT INTO link_item(`name`, link, movie_link_id) VALUES(#{name}, #{link}, #{movieLinkId})")
    void insertLinkItem(@Param("name") String name, @Param("link") String link, @Param("movieLinkId") long movieLinkId);

    /**
     * 查询这个类型资源下面的所有的具体资源，别不mp4类型资源下所有的链接
     * @param movieLinkId
     * @return
     */

    @Results({
            @Result(property = "id", column = "id", id = true, javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "name", column = "name", id = true, javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "link", column = "link", id = true, javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    @Select("SELECT id, `name`, link FROM link_item WHERE movie_link_id = #{movieLinkId}")
    List<MovieLink.LinkItem> getLinkItem(@Param("movieLinkId") long movieLinkId);


}
