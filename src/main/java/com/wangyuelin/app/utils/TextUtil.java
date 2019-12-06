package com.wangyuelin.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 描述:
 *
 * @outhor wangyuelin
 * @create 2018-06-25 下午4:04
 */
public class TextUtil {

    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }


    public static Integer toInteger(String value) {
        if (TextUtil.isEmpty(value)) {
            return null;
        }
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Float toFloat(String value) {
        if (TextUtil.isEmpty(value)) {
            return null;
        }
        try {
            return Float.valueOf(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 空格分隔符
     * @return
     */
    public static List<String> splitWithSpace(String in) {
        ArrayList<String> list = new ArrayList<String>();
        if (TextUtil.isEmpty(in)) {
           return  list;
        }
        int len = in.length();
        int start = 0;
        for (int i = 0; i < len; i++) {
            char c = in.charAt(i);
            if (c == 32 || c == 160 || i == len -1) {
                list.add(in.substring(start, i == (len -1) ?  (i +1) : i ));
                start = i;
            }
        }
        return list;
    }

}