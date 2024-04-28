package com.example.common.kit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnicodeKit {
    public static String unicode2string(String s) {
        List<String> list = new ArrayList<String>();
        String zz = "\\\\u[0-9,a-z,A-Z]{4}";

        // 正则表达式用法参考API
        Pattern pattern = Pattern.compile(zz);
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            list.add(m.group());
        }
        for (int i = 0, j = 2; i < list.size(); i++) {
            String st = list.get(i).substring(j, j + 4);

            // 将得到的数值按照16进制解析为十进制整数，再強转为字符
            char ch = (char) Integer.parseInt(st, 16);
            // 用得到的字符替换编码表达式
            s = s.replace(list.get(i), String.valueOf(ch));
        }
        return s;
    }

    /*
     * 将字符转为Unicode码表示
     */
    public static String string2unicode(String s) {
        int in;
        String st = "";
        for (int i = 0; i < s.length(); i++) {
            in = s.codePointAt(i);
            st = st + "\\u" + Integer.toHexString(in).toUpperCase();
        }
        return st;
    }
    
    public static void main(String[] args) {
       String s = UnicodeKit.unicode2string("{\"d\":\"{\u0027id\u0027:\u00274\u0027}\"}");
       System.out.println(s);
    }
}
