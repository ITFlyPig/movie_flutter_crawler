package com.wangyuelin.app.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    public static String[] toArray(String str) {
        return new String[]{str};
    }
    public static List<String> toList(String str) {
        ArrayList<String> list = new ArrayList<String>();
        list.add(str);
        return list;
    }
}
