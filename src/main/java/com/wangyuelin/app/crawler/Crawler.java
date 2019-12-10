package com.wangyuelin.app.crawler;

import com.wangyuelin.app.utils.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

@Component
public class Crawler {
    @Autowired
    private Spider mSpider;


    private static RootPageProcessor rootPageProcessor;
    private static DBPipeline dbPipeline;

    @Autowired
    public Crawler(RootPageProcessor rootPageProcessor, DBPipeline dbPipeline) {
        Crawler.rootPageProcessor = rootPageProcessor;
        Crawler.dbPipeline = dbPipeline;
    }

    @Bean
    public Spider ctrateCrawler() {
        Spider spider = Spider.create(rootPageProcessor);
        spider.addPipeline(dbPipeline);
        return spider;
    }


    /**
     * 添加要爬取的url
     * @param url
     */
    public void addUrl(String url) {
        if (TextUtil.isEmpty(url)) {
            return;
        }
        mSpider.addRequest(new Request(url));
        if (mSpider.getStatus() == Spider.Status.Running) {
            return;
        }
        mSpider.start();

    }

}
