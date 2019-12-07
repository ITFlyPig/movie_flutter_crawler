package com.wangyuelin.app.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.LruCache;

@CacheNamespace(eviction = LruCache.class, flushInterval = 60000L, size = 1024, readWrite = true)
@Mapper
public interface CategoryMapper {

    /**
     * 插入分类
     * @param value
     * @param name
     */
    @Insert("INSERT INTO category(`name`, `value`) VALUES(#{name}, #{value})")
    void insert(@Param("value") int value, @Param("name") String name);

    /**
     * 据分类的名称查询分类的值
     * @param name
     * @return
     */
    @Select("SELECT `value` FROM category WHERE `name` LIKE #{name}  LIMIT 1;")
    int getByName(@Param("name") String name);

    /**
     * 查询电影和分类的关系是否存在
     * @param categoryId
     * @param movieId
     * @return
     */
    @Select("SELECT id FROM category_relationship WHERE category_id  = #{categoryId} AND movie_id = #{movieId}  LIMIT 1")
    Integer getCategoryRelationship(@Param("categoryId") int categoryId, @Param("movieId") int movieId);

    /**
     * 绑定电影所属的分类
     * @param categoryId
     * @param movieId
     */
    @Insert("INSERT INTO category_relationship(category_id, movie_id) VALUES(#{categoryId}, #{movieId})")
    void insertCategoryRelationship(@Param("categoryId") int categoryId, @Param("movieId") int movieId);

}
