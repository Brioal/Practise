package brioal.homework1;

import java.util.Scanner;

/**
 * Created by brioal on 15-10-8.
 */

public class ComplexTest {
    public static void main(String[] args) {
        double first_real = 0;
        double first_imga = 0;
        String first_char = "";
//        获取第二个数
        double second_real = 0;
        double second_imga = 0;
        String second_char = "";
        boolean flag = true;

        System.out.println(Complex.getDesigner());
        Scanner keyin = new Scanner(System.in);
        System.out.print("请输入第一个复数:(例如3+4i)");
        String first = keyin.nextLine();
        System.out.println("请输入第二个复数:(例如3+4i)");
        String second = keyin.nextLine();
        //通过正则表达式来分割字符串获取数据
        String[] first_numble = first.split("\\D");
        String[] first_chars = first.split("\\d");
        String[] second_numble = second.split("\\D");
        String[] second_chars = second.split("\\d");
        try {
            //        获取第一个数
            first_real = Integer.parseInt(first_numble[0]);
            first_imga = Integer.parseInt(first_numble[1]);
            first_char = first_chars[1];
            if (first_char.equals("-")) {
                first_imga = -first_imga;
            }
//        获取第二个数
            second_real = Integer.parseInt(second_numble[0]);
            second_imga = Integer.parseInt(second_numble[1]);
            second_char = second_chars[1];
            if (second_char.equals("-")) {
                second_imga = -second_imga;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        Complex first_complex = new Complex(first_real,first_imga);
        Complex second_complex = new Complex(second_real,second_imga);
        while (true) {
            System.out.print("第一个数是: ");
            System.out.print(first_real);
            System.out.print(first_char);
            System.out.println(first_imga + "i");
            System.out.print("第二个数是: ");
            System.out.print(second_real);
            if (second_char.equals("+")) {
            System.out.print(second_char);
            }
            System.out.println(second_imga+"i");

            System.out.println("=====请选择运算=====");
            System.out.println("   1 . 加法        ");
            System.out.println("   2 . 减法        ");
            System.out.println("   3 . 乘法        ");
            System.out.println("   4 . 除法        ");
            System.out.println("   5 . 退出       ");
            int select = keyin.nextInt();
            Complex result = null;
            switch (select) {
                case 1:
                    result = first_complex.add(second_complex);
                    break;
                case 2:
                    result = first_complex.sub(second_complex);
                    break;
                case 3:
                    result = first_complex.mul(second_complex);
                    break;
                case 4:
                    result = first_complex.div(second_complex);
                    break;
                case 5:
                    System.out.println("程序退出");
                    System.exit(0);
                default:
                    System.out.println("输入错误,程序退出");
                    return;
            }
            System.out.println("计算结果是:" + result);



        }

    }

}
