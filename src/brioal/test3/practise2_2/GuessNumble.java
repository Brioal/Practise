package brioal.test3.practise2_2;

import java.util.Scanner;

/**
 * Created by brioal on 15-9-10.
 */
public class GuessNumble {
    //空构造方法
    public void Read() {

    }

    public static void main(String[] args) {
        int realNumble = (int) (Math.random() * 100) + 1;
        System.out.println("给你一个1-100之内的整数,请猜测这个数");

        int guessNUmble = 0;
        int guessCount = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你猜测的数据");
        guessNUmble = sc.nextInt();
        while (guessNUmble != realNumble) {
            if (guessNUmble > realNumble) {
                System.out.println("大了");
                guessNUmble = sc.nextInt();
            } else {
                System.out.println("小了");
                guessNUmble = sc.nextInt();
            }
            guessCount++;
        }
        if (guessCount < 4) {
            System.out.println("这么快就猜对了");
        } else if (guessCount < 8) {
            System.out.println("正常智力");

        } else {
            System.out.println("正常智力");
        }
    }
}
