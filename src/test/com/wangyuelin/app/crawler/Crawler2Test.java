package com.wangyuelin.app.crawler;

import com.wangyuelin.app.mapper.UrlStatusMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Crawler2Test {
    @Autowired
    private Crawler crawler;

    @Test
    public void startCrawler() throws Exception {
        crawler.addUrl("http://www.zuidazy2.net/?m=vod-detail-id-74223.html");
    }




}
