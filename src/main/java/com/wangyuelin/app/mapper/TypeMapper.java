package com.wangyuelin.app.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.LruCache;

import java.util.List;

@CacheNamespace(eviction = LruCache.class, flushInterval = 60000L, size = 1024, readWrite = true)
@Mapper
public interface TypeMapper {

    /**
     * 插入分类
     * @param name
     * @param value
     */
    @Insert("INSERT INTO movie_type(`name`, `value`) VALUES(#{name}, #{value})")
    void insertType(@Param("name") String name, @Param("value") int value);

    /**
     * 据分类的value查询id
     * @param value
     * @return
     */
    @Select("SELECT id FROM movie_type WHERE `value` = #{value}")
    Integer getTypeId(@Param("value") int value);

    /**
     * 记录电影属于哪种分类，动作、恐怖等
     * @param movieId
     * @param typeId
     */
    @Insert("INSERT INTO type_relationship(movie_id, type_id) VALUES(#{movieId}, #{typeId})")
    void insertTypeRelationship(@Param("movieId") long movieId, @Param("typeId") long typeId);

    /**
     * 判断关系是否存在
     * @param movieId
     * @param typeId
     * @return
     */
    @Select("SELECT id FROM type_relationship WHERE movie_id = #{movieId} AND type_id = #{typeId}")
    Integer getRelationshipId(@Param("movieId") long movieId, @Param("typeId") long typeId);

    @Select("SELECT movie_id FROM type_relationship WHERE type_id = #{typeId}")
    List<Integer> getMovieIds(@Param("typeId") long typeId);


}
