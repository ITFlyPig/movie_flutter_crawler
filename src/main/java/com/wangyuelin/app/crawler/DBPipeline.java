package com.wangyuelin.app.crawler;

import com.wangyuelin.app.bean.Movie;
import com.wangyuelin.app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class DBPipeline implements Pipeline {
    @Autowired
    private MovieService movieService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("DBPipeline process");
         Object obj = resultItems.get("movie");
         if (obj instanceof Movie) {
             Movie movie = (Movie) obj;
             movieService.save(movie);
         }


    }
}
