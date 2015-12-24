package brioal.test6.practise3_2;

import java.util.Scanner;

/**
 * Created by brioal on 15-10-15.
 */

public class MonthTest {

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        System.out.println("请输入要显示万年历的年份:");
        int year = keyin.nextInt();
        System.out.println("请输入要显示的万年历的月份:");
        int month = keyin.nextInt();
        try {
            if (year < 0) {
                throw new MyException("输入的年份为负数,请输入正确的值");
            }
            if (month < 0 || month > 12) {
                throw new MyException("输入的月份不在范围内,请输入正确的值");
            }
            System.out.println("此处输入正常是才会执行");
            Month m = new Month(year, month);
            System.out.println(m);
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
    }
}

