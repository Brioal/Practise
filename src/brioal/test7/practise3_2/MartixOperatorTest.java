package brioal.test7.practise3_2;

import java.io.File;
import java.util.Scanner;

/**
 * Created by brioal on 15-10-14.
 */

public class MartixOperatorTest {
    public static void main(String[] args) {
//        通过读取操作获得两个Martrix对象
        Martrix first = MartrixOperator.Read("data/first_.txt");
        Martrix second = MartrixOperator.Read("data/second.txt");
//        输出Martrix对象
        System.out.println("第一个数是:\n" + first);
        System.out.println("第二个数是:\n" + second);
//        操作选择
        System.out.println("请选择要进行的运算:");
        System.out.println("======================================");
        System.out.println("================1. 加法===============");
        System.out.println("================2. 减法===============");
        System.out.println("================3. 乘法===============");
        System.out.println("================4. 除法===============");
//        捕获输入进行运算
        Scanner keyin = new Scanner(System.in);
        int select = keyin.nextInt();
        switch (select) {
            case 1:
                try { // 过滤,进行加法的两个矩阵的行列值要对应相等
                    if ((first.getRow() == second.getRow()) && (first.getCol() == second.getCol())) {
                        System.out.println("加法结果是:\n" + MartrixOperator.add(first, second));
                        SaveAndRead(MartrixOperator.add(first, second), "data/add.txt");
                    } else {
                        throw new RowColException("进行加减法运算的两个矩阵,行列值必须对应相等");
                    }
                } catch (RowColException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try { // 过滤,进行减法的两个矩阵的行列值要对应相等
                    if ((first.getRow() == second.getRow()) && (first.getCol() == second.getCol())) {
                        System.out.println("减法结果是:\n" + MartrixOperator.sub(first, second));
                        SaveAndRead(MartrixOperator.sub(first, second), "data/sub.txt");


                    } else {
                        throw new RowColException("进行加减法运算的两个矩阵,行列值必须对应相等");
                    }
                } catch (RowColException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try { // 过滤,进行乘法的两个矩阵,第一个数的列和第二个数的行相等
                    if ((first.getRow() == second.getRow()) && (first.getCol() == second.getCol())) {
                        System.out.println("乘法结果是:\n" + MartrixOperator.mul(first, second));
                        SaveAndRead(MartrixOperator.mul(first, second), "data/mul.txt");
                    } else {
                        throw new RowColException("进行加减法运算的两个矩阵,行列值必须对应相等");
                    }
                } catch (RowColException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                try { // 过滤,进行处罚运算的两个矩阵必须是行列相等的方阵
                    if ((first.getRow()==first.getCol())&&(second.getRow()==second.getCol())&&(first.getRow()==second.getRow())) {
                        System.out.println("除法结果是:\n" + MartrixOperator.div(first, second));
                        SaveAndRead(MartrixOperator.div(first, second), "data/div.txt");
                    } else {
                        throw new RowColException("进行加减法运算的两个矩阵,行列值必须对应相等");
                    }
                } catch (RowColException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("输入错误!,程序结束");
                System.exit(0);
        }
    }

    //保存数据到本地并且读取显示
    public static void SaveAndRead(Martrix martrix, String filename) {
        System.out.print("运算结果保存到"+filename);
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MartrixOperator.Save(martrix, filename);
        System.out.println();
        if (new File(filename).exists()) {
            System.out.print("检测到运算结果:"+filename+"读取中");
            for (int i = 0; i < 5; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("读取到的结果为:\n" + MartrixOperator.Read(filename));
        }
    }
}
