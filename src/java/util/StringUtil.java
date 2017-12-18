package util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    //提取字符串中的数字
    public static List<String> getNumInString(String str) {
        String string = "";
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <= str.length() - 1; i++) {
            char ci = str.charAt(i);
            String bi=String.valueOf(ci);
            int in = (int) ci;
            if (in >= 48 && in <= 57||bi.equals("-")) {
                //是数字
                string += ci;
            } else {
                if (!string.equals("")) {
                    strings.add(string);
                }
                string = "";
            }
        }
        if (!string.equals("")) {
            strings.add(string);
        }
        return strings;
    }

    public static void main(String[] args) {

        List<String> string = getNumInString("123a-1234sdgf-3a12345sbas123123f11113a346");
        for (int i = 0; i <= string.size() - 1; i++) {
            System.out.println(string.get(i));
        }
    }

}
