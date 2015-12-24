package brioal.test13.practise1_4;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Brioal on 2015/12/23.
 */
public class EcondeTest {
    public static void main(String[] args) throws Exception {
        String str = "Jackson`s bike - bell cost $ 5 ÖÐ¹ú";
        String str2 = URLEncoder.encode(str, "UTF-8");
        System.out.println(str);
        System.out.println(str2);
        String str3 = URLDecoder.decode(str2, "UTF-8");
        System.out.println(str3);
    }
}
