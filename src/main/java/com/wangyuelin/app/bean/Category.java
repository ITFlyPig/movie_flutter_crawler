package com.wangyuelin.app.bean;

public enum Category {
    MOVIE(1, "电影"),
    SITCOM(2, "连续剧"),
    VARIETY(3, "综艺"),
    COMIC(4, "动漫");

    Category(int value, String name) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private int value;
}
