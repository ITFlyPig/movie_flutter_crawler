package com.wangyuelin.app.crawler;

import com.wangyuelin.app.crawler.sites.zuida.ZuidaPageProcessor;
import com.wangyuelin.app.utils.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;

@Component
public class PageProcessorFactory {
    private static HashMap<String, PageProcessor> cacheMap = new HashMap<String, PageProcessor>();

    @Autowired
    private ZuidaPageProcessor zuidaPageProcessor;

    public  PageProcessor getPageProcessor(String url) {
        if (TextUtil.isEmpty(url)) {
            return null;
        }
        PageProcessor pageProcessor = null;
        if (url.contains("www.zuida")) {
            String key = "zuida";
            pageProcessor = cacheMap.get(key);
            if (pageProcessor == null) {
                pageProcessor = zuidaPageProcessor;
                cacheMap.put(key, pageProcessor);
            }
        }
        return pageProcessor;
    }
}
