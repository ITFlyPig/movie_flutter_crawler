package com.wangyuelin.app.bean;

/**
 * 采集的网站
 */
public enum  SiteType {
    ZUIDA("http://www.zuidazy2.net", "zuida");

    SiteType(String host, String name) {
        this.host = host;
        this.name = name;
    }

    private String host;
    private String name;

}
