package com.wangyuelin.app.service;

import com.wangyuelin.app.bean.Movie;
import com.wangyuelin.app.mapper.MovieMapper;
import com.wangyuelin.app.service.itf.IMovie;
import com.wangyuelin.app.utils.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @outhor wangyuelin
 * @create 2018-06-25 下午4:21
 */
@Service
public class MovieService implements IMovie {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public long save(Movie movie) {
        long id = -1;
        if (movie == null || TextUtil.isEmpty(movie.getName())) {
            return id;
        }
        Movie savedMovie = movieMapper.getByName(movie.getName());

        if (savedMovie == null) {
            movieMapper.insert(movie);
            savedMovie = movieMapper.getByName(movie.getName());
            if (savedMovie != null) {
                id = savedMovie.getId();
            }
        } else {
            //TODO:对比新的和已存在的，将差别更新进去
            //目前不做处理，因为电影已经存在了
            id = savedMovie.getId();
        }

        return id;
    }

    @Override
    public void update(Movie movie) {

    }

    @Override
    public Movie getByName(String name) {
        return null;
    }

    @Override
    public Movie getById(long id) {
        return null;
    }
}