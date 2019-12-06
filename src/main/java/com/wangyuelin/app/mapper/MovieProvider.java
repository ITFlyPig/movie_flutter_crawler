package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.Movie;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class MovieProvider {

    public String insert(@Param("movie") Movie movie) {
        return new SQL(){
            {
                INSERT_INTO("movie");
                INTO_COLUMNS("name");
                INTO_VALUES("#{movie.name}");

            }
        }.toString();

    }
}
