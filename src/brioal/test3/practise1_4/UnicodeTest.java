package brioal.test3.practise1_4;

/**
 * Created by brioal on 15-9-10.
 */
public class UnicodeTest {
    public static void main(String[] args) {
        int �� = '��';
        System.out.println("Unicode����:��������������ַ�");
        for (int i = 0; i < 20; i++) {
            System.out.println("     "+��+":"+(char)��);
            ��++;
        }
    }
}
