package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieMapperTest {
    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void insert() throws Exception {
        Movie movie = new Movie();
        movie.setName("X战警");
        movieMapper.insert(movie);
    }

}
