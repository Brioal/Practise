package brioal.test5.practise1_3;


import java.util.Date;

/**
 * Created by brioal on 15-9-20.
 */
public class Flyhorse {
    public static void main(String[] args) {
        Trangle trangle = new Trangle(12, 3, 104);
        trangle.jsmi();
        trangle.set(3, 4, 5);
        trangle.jsmi();
        Date 今天 = new Date();
        System.out.println("今天是:"+今天);
    }
}
