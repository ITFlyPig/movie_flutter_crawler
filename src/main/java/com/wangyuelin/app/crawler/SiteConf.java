package com.wangyuelin.app.crawler;

import us.codecraft.webmagic.Site;

public class SiteConf {
    public static Site zuidaSite = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);
}
