package brioal.test6.practise2_5;


import java.util.Arrays;

/**
 * Created by brioal on 15-10-6.
 */

public class ArrayTest {
    public static void main(String[] args) {
        int[] a = {5, 1, 3, 2, 4, 8, 7, 9, 10, 6};
        System.out.println("排序前:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        Arrays.sort(a);
        System.out.print("\n排序后:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        int k = Arrays.binarySearch(a, 4);//二分法
        if (k < 0) {
            System.out.println("\n没有找到元素值4");
        } else {
            System.out.println("\n元素值4再素组中的下标为:" + k);
        }
        int c[] = new int[10];
        int d[] = new int[10];
        Arrays.fill(c, 4); // 填充数组
        Arrays.fill(d, 4); // 填充数组
        System.out.println("\n数组c:");
        for (int i = 0; i < c.length; i++) {
            System.out.print(" " + c[i]);
        }
        System.out.println("\nnequals(a,c)=" + Arrays.equals(a, c));
        System.out.println("\nnequals(c,d)=" + Arrays.equals(c, d));
    }

}
