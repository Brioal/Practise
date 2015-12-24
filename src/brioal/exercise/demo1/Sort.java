package brioal.exercise.demo1;

import java.util.Scanner;

/**
 * Created by Null on 2015/10/17.
 * 此例用于演示常用的8大排序方法
 */
public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] data = new int[]{2, 5, 4, 27, 98, 43, 12, 45, 17, 67, 43, 86, 21, 96, 32, 56, 23};
        int[] result;
        System.out.println("原数组");
        for (int a : data) {
            System.out.printf("%3d", a);
        }
        System.out.println();
        System.out.println("请选择要使用的排序方法");
        Scanner keyin = new Scanner(System.in);
        System.out.println("1.直接插入排序");
        System.out.println("2.希尔排序(最小增量排序)");
        System.out.println("3.简单选择排序");
        switch (keyin.nextInt()) {
            case 1:
                System.out.println("直接插入排序法:假设前(n-1)个数是有序的,要将第n个数插入,使得这n个数是有序的");
                result = sort.method1(data);
                sort.print(result);
                break;
            case 2:
                System.out.println("希尔排序(最小增量排序):将数组中的n个元素按照增量分组,将每组进行直接插入排序,然后令d=n/2,z再进行排序,直到d=1,然后进行整体直接插入排序,即可获得结果");
                result = sort.method2(data);
                sort.print(result);
                break;
            case 3:
                System.out.println("简单选择排序:在要排序的一组数中，选出最小的一个数与第一个位置的数交换；\n" +
                        "然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。");
                result = sort.method3(data);
                sort.print(data);
                break;
        }

    }

    //直接插入排序
    public int[] method1(int[] data) {
        int temp = 0;


        for (int i = 1; i < data.length; i++) {
            int j = i - 1;
            temp = data[i];
            for (; j >= 0 && temp < data[j]; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = temp;
        }
        return data;
    }

    //    希尔排序
    public int[] method2(int[] data) {
        double d1 = data.length;
        int temp = 0;
        while (true) {
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < data.length; j += d) {
                    int k = j - d;
                    temp = data[j];
                    for (; k >= 0 && temp < data[k]; k = k - d) {
                        data[k + d] = data[k];
                    }
                    data[k + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }

        return data;
    }

    //简单选择排序
    public int[] method3(int[] data) {
        int position = 0;
        for (int i = 0; i < data.length; i++) {
            int j = i + 1;
            position = i;
            int temp = data[i];
            for (; j < data.length; j++) {
                if (data[j] < temp) {
                    temp = data[j];
                    position = j;
                }
            }
            data[position] = data[i];
            data[i] = temp;
        }
        return data;
    }

    //打印数组的方法
    public void print(int[] data) {
        for (int a : data) {
            System.out.printf("%3d", a);
        }
        System.out.println();
    }
}

