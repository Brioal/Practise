package brioal.test8.practise1_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Null on 2015/10/22.
 */
public class PatternTest {
    public static void main(String[] args) {
        Pattern p ;
        Matcher m ;
        String s1 = "0A1A2A3A4A5A6A7A8A9A";
        p = Pattern.compile("\\dA\\d");  //匹配模式
        m = p.matcher(s1); // 匹配对象
        while (m.find()) {
            String str = m.group(); //获取匹配成功的字符串序列
            System.out.println("从"+m.start()+"到"+m.end()+"匹配模式子序列:");
            System.out.println(str);
        }
        String temp = m.replaceAll("***");     //将匹配到的字符串序列替换
        System.out.println(temp);
        System.out.println(s1);
        m = p.matcher("9A00A3");
        if (m.matches()) {
            String str = m.group();
            System.out.println(str);
        } else {
            System.out.println("不完全匹配");
        }
        if (m.lookingAt()) { // 从头开始匹配,但是不用全部匹配
            String str = m.group();
            System.out.println(str);
        }
    }
}
