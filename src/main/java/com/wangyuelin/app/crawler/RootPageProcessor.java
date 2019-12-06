package com.wangyuelin.app.crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class RootPageProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        String url = page.getUrl().get();
        //将不同网站的页面分给不同的PageProcessor处理
        PageProcessor pageProcessor = PageProcessorFactory.getPageProcessor(url);
        if (pageProcessor != null) {
            pageProcessor.process(page);
        }
    }

    @Override
    public Site getSite() {
        return SiteConf.zuidaSite;
    }
}
