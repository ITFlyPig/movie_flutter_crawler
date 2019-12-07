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
public class MovieMapperTest {
    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void insert() throws Exception {
        Movie movie = new Movie();
        movie.setName("X战警");
        ArrayList<String> actors = new ArrayList<String>();
        actors.add("王跃林");
        actors.add("大意");
        movie.setActors(actors);
        movieMapper.insert(movie);
    }

    @Test
    public void getById() throws Exception {
        Movie movie = movieMapper.getById(3);
        System.out.println("查询成功：" + movie.toString());
    }

}
