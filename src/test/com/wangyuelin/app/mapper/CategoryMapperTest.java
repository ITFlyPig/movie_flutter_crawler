package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void insert() throws Exception {
      categoryMapper.insert(1, "电影");
    }

    @Test
    public void getByName() throws Exception {
        int value = categoryMapper.getByName("电影");
        System.out.println("电影对应的值：" + value);
    }

    @Test
    public void getCategoryRelationship() throws Exception {
        Integer value = categoryMapper.getCategoryRelationship(1, 1);
        System.out.println("电影和分类的关系id：" + value);
    }

    @Test
    public void insertCategoryRelationship() throws Exception {
        categoryMapper.insertCategoryRelationship(1, 1);
    }




}
