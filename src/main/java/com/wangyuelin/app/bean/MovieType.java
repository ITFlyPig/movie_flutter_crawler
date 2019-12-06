package com.wangyuelin.app.bean;

import com.wangyuelin.app.utils.TextUtil;

/**
 * 电影的类型
 */
public enum MovieType {
    ACTION(1, "动作"),
    COMEDY(2, "喜剧"),
    SCIENCE(3, "科幻"),
    HORROR(4, "恐怖"),
    WAY(5, "战争"),
    LOVE(6, "爱情"),
    DRAMATIC(7, "剧情"),
    DOCUMENTARY(8, "纪录片"),
    THRILLER(9, "惊悚"),
    FULI(10, "福利"),
    ETHICAL(11, "伦理");

    MovieType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 将字符转为对应的电影类型
     * @param type
     * @return
     */
    public static MovieType getType(String type) {
        if (TextUtil.isEmpty(type)) {
            return null;
        }
        MovieType[] movieTypes = MovieType.values();
        for (MovieType movieType : movieTypes) {
            if (type.contains(movieType.name)) {
                return movieType;
            }
        }
        return null;
    }


}
