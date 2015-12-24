package brioal.test3.practise2_1;

import java.util.Scanner;

/**
 * Created by brioal on 15-9-10.
 */
public class InputDouble {
    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个浮点数");

        a = sc.nextFloat();

        b = a * a;
        c = a * a * a;
        System.out.println(b);
        System.out.println(c);
    }
}
