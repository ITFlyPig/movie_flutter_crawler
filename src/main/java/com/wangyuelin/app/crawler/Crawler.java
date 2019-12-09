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

    @Autowired
    public Crawler(RootPageProcessor rootPageProcessor) {
        Crawler.rootPageProcessor = rootPageProcessor;
    }

    @Bean
    public Spider ctrateCrawler() {
        return Spider.create(rootPageProcessor);
    }


    /**
     * 添加要爬取的url
     * @param url
     */
    public void addUrl(String url) {
        if (TextUtil.isEmpty(url)) {
            return;
        }
        if (mSpider.getStatus() == Spider.Status.Running) {
            return;
        }
        mSpider.addRequest(new Request(url));
        mSpider.start();

    }

}
