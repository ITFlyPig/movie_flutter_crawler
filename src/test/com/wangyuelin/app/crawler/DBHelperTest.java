package com.wangyuelin.app.crawler;


import com.wangyuelin.app.bean.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBHelperTest {

    @Test
    public void insertCategoryRelationship() throws Exception {
        Movie movie = new Movie();
        movie.setName("哎 太难了");
    }




}