package com.wangyuelin.app.service; 

import com.wangyuelin.app.bean.Movie;
import com.wangyuelin.app.mapper.MovieMapper;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void save() throws Exception {
        Movie movie = new Movie();
        movie.setName("复仇者联盟");
        long id = movieService.save(movie);
        System.out.println("电影的id：" + id);
//        long start1 = System.currentTimeMillis();
//        movieMapper.insert(movie);
//        System.out.println("插入花费的时间：" + (System.currentTimeMillis() - start1));
//
//        int i = 0;
//        while (i < 10) {
//            i ++;
//            long start2 = System.currentTimeMillis();
//            movieMapper.getByName(movie.getName());
//            System.out.println("查询花费的时间：" + (System.currentTimeMillis() - start2));
//        }

    }
}