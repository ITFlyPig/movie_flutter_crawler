package com.wangyuelin.app.crawler;

import com.wangyuelin.app.crawler.sites.zuida.ZuidaPageProcessor;
import com.wangyuelin.app.utils.TextUtil;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;

public class PageProcessorFactory {
    private static HashMap<String, PageProcessor> cacheMap = new HashMap<String, PageProcessor>();

    public static PageProcessor getPageProcessor(String url) {
        if (TextUtil.isEmpty(url)) {
            return null;
        }
        PageProcessor pageProcessor = null;
        if (url.contains("www.zuida")) {
            String key = "zuida";
            pageProcessor = cacheMap.get(key);
            if (pageProcessor == null) {
                pageProcessor = new ZuidaPageProcessor();
                cacheMap.put(key, pageProcessor);
            }
        }
        return pageProcessor;
    }
}
