package com.wangyuelin.app.crawler.sites.zuida;

import com.wangyuelin.app.crawler.SiteConf;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class ZuidaPageProcessor implements PageProcessor {
    ZuidaMovieDetailPageProcessor zuidaMovieDetailPageProcessor;

    public ZuidaPageProcessor() {
        zuidaMovieDetailPageProcessor = new ZuidaMovieDetailPageProcessor();
    }

    @Override
    public void process(Page page) {
        String url = page.getUrl().get();
        zuidaMovieDetailPageProcessor.process(page);


    }

    @Override
    public Site getSite() {
        return SiteConf.zuidaSite;
    }
}
