package brioal.test8.practise2_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Null on 2015/10/22.
 */
public class Read {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("data/phone.txt");
        BufferedReader bin = new BufferedReader(reader);
        String s = bin.readLine();
        System.out.println(s);
        System.out.println("\n以;作为分隔符来提取字符串\n");
        String[] sa = s.split(";"); // 分割已;隔开的字符串
        for (String ss : sa) {
            System.out.println("=="+ss);
        }
        System.out.println("\n\n以正则表达式[,;]作为分隔符来提取字符串\n");
        sa = s.split("[,;]"); //分割以,或者;分开德尔字符串
        for (String ss : sa) {
            System.out.print("=="+ss);
        }

        System.out.println("\n\n用正则表达式[\\D*&&[^-]]提取所有的电话号码\n");
        sa = s.split("[\\D&&[^-]]");
        for (String ss : sa) {
            System.out.println(ss+"#");
        }

        System.out.println("\n\n将兰州的电话改为0931-XXXXXXX");
        //给定字符串替换符合正则表达式的字符串
        String s1 = s.replaceAll("0931[-]\\d{7}", "0931-x{7}");
        String s2 = s.replaceAll("0931[-]\\d{7}", "0931-xxxxxxx");
        System.out.println("s=" + s);
        System.out.println("s1="+s1);
        System.out.println("s2=" + s2+"\n\n");
        String s3 = "a99+0x55f-55/0xAF+33";
        String [] sd = s3.split("0[Xx]([0-9a-fA-F])+");
        for (String ss : sd) {
            System.out.println("=="+ss);
        }

    }
}
