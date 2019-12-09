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
public class TypeMapperTest {
    @Autowired
    private TypeMapper typeMapper;

    @Test
    public void insert() throws Exception {
        typeMapper.insertType("动作", 2);
    }

    @Test
    public void getId() throws Exception {
        Integer id = typeMapper.getTypeId(2);
        System.out.println("id：" + id);
    }

}
