package com.wangyuelin.app.crawler.sites.zuida;

import com.wangyuelin.app.crawler.SiteConf;
import com.wangyuelin.app.utils.TextUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class ZuidaPageProcessor implements PageProcessor {
    ZuidaMovieDetailPageProcessor zuidaMovieDetailPageProcessor;
    ZuidaMovieListPageProcessor zuidaMovieListPageProcessor;

    public ZuidaPageProcessor() {
        zuidaMovieDetailPageProcessor = new ZuidaMovieDetailPageProcessor();
        zuidaMovieListPageProcessor = new ZuidaMovieListPageProcessor();
    }

    @Override
    public void process(Page page) {
        String url = page.getUrl().get();
        if (TextUtil.isEmpty(url)) {
            return;
        }
        if (url.contains("detail")) {//详情页面
            zuidaMovieDetailPageProcessor.process(page);
        } else  if(url.contains("type")){//列表
            zuidaMovieListPageProcessor.process(page);
        }



    }

    @Override
    public Site getSite() {
        return SiteConf.zuidaSite;
    }
}
