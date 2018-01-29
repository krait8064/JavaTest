package cn.krait8063;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {
    public static void main(String[] arg) {
        String text = "(content:\"rcpt to root\";pcre:\"word\";)";
        System.out.println("origin" + text);
        String rule1 = "content:\".+\"";    //贪婪模式
        String rule2 = "content:\".+?\"";    //非贪婪模式

        System.out.println("文本：" + text);
        System.out.println("贪婪模式：" + rule1);
        Pattern p1 = Pattern.compile(rule1);
        Matcher m1 = p1.matcher(text);
        while (m1.find()) {
            System.out.println("匹配结果：" + m1.group(0));
        }

        System.out.println("非贪婪模式：" + rule2);
        Pattern p2 = Pattern.compile(rule2);
        Matcher m2 = p2.matcher(text);
        while (m2.find()) {
            System.out.println("匹配结果：" + m2.group(0));
        }
    }
}
