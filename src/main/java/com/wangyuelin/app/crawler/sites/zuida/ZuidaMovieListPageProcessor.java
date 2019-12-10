package com.wangyuelin.app.crawler.sites.zuida;

import com.wangyuelin.app.crawler.SiteConf;
import com.wangyuelin.app.utils.TextUtil;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Component
public class ZuidaMovieListPageProcessor implements PageProcessor {
    private static String HOST = "http://www.zuidazy2.net/";
    @Override
    public void process(Page page) {
        //解析得到详情链接
        List<String> detailLinks = page.getHtml().xpath("div[@class='xing_vb']//a/@href").all();
        if (detailLinks != null) {
            for (String detailLink : detailLinks) {
                if (!TextUtil.isEmpty(detailLink)) {
                    page.addTargetRequest(new Request(HOST + detailLink));
                    System.out.println("添加详情页链接：" + detailLink);
                }
            }
        }

        //解析下一页的链接
        List<Selectable> pages = page.getHtml().xpath("div[@class='pages']/a").nodes();
        for (Selectable pageLink : pages) {
            String text = pageLink.xpath("a/text()").get();
            if (!TextUtil.isEmpty(text) && text.equals("下一页")) {
                String pageUrl = pageLink.xpath("a/@href").get();
                if (!TextUtil.isEmpty(pageUrl)) {
//                    page.addTargetRequest(new Request(HOST + pageUrl));
//                    System.out.println("添加下一页链接：" + pageUrl);
                }
            }
        }

    }

    @Override
    public Site getSite() {
        return SiteConf.zuidaSite;
    }
}
