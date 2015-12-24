package brioal.test5.practise1_1;

/**
 * Created by brioal on 15-9-13.
 */
//验证Static 和 Final关键字
public class StaticAndFinal {
    static int i = 10;
    static final int k = 20;

    static {
         i = i +5;
    }

    public static void main(String[] args) {
//        i = 7
        System.out.println("i="+i);
//        k=20
        System.out.println("k="+k);
    }
    static {
        i = i / 2;
    }
}
