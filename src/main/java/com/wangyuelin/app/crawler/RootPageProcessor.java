package com.wangyuelin.app.crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class RootPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Override
    public void process(Page page) {
        String url = page.getUrl().get();
        //据不同的url在添加不同的解析类

    }

    @Override
    public Site getSite() {
        return site;
    }
}
