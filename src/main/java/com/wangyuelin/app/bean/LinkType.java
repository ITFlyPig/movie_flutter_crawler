package com.wangyuelin.app.bean;

/**
 * 电影资源链接的类型
 */
public enum  LinkType {
    M3U8(1),
    HTML_PLAY(2),
    DOWNLOAD_LINK(3),
    UNKNOW(4);

    LinkType(int value) {
        this.value = value;
    }

    private int value;

}
