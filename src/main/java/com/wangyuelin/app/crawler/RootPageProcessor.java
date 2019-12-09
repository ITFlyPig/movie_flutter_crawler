package com.wangyuelin.app.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class RootPageProcessor implements PageProcessor {

    @Autowired
    private PageProcessorFactory pageProcessorFactory;

    @Override
    public void process(Page page) {
        System.out.println("RootPageProcessor process");
        String url = page.getUrl().get();
        //将不同网站的页面分给不同的PageProcessor处理
        PageProcessor pageProcessor = pageProcessorFactory.getPageProcessor(url);
        if (pageProcessor != null) {
            pageProcessor.process(page);
        }
    }

    @Override
    public Site getSite() {
        return SiteConf.zuidaSite;
    }
}
