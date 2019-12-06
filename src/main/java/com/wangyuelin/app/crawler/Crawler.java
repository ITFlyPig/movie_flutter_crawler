package com.wangyuelin.app.crawler;

import com.wangyuelin.app.utils.TextUtil;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;

public class Crawler {
    private Spider mSpider;

    public Crawler() {
        mSpider = Spider.create(new RootPageProcessor());
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

    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        crawler.addUrl("http://www.zuidazy2.net/?m=vod-detail-id-71392.html");

    }
}
