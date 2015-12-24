package brioal.test3.practise1_4;

/**
 * Created by brioal on 15-9-10.
 */
public class UnicodeTest {
    public static void main(String[] args) {
        int 中 = '中';
        System.out.println("Unicode编码:各编码所代表的字符");
        for (int i = 0; i < 20; i++) {
            System.out.println("     "+中+":"+(char)中);
            中++;
        }
    }
}
