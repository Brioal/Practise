package brioal.exercise.demo1;

/**
 * Created by Null on 2015/10/18.
 * 获取一个数据里面最小的数
 */
public class FindMin {
    public static void main(String[] args) {
        int[] data = new int[]{98, 43, 44, 56, 56, 2, 46, 78, 99, 12, 32};
        System.out.println("原数据");
        for (int a : data) {
            System.out.printf("%4d",a);
        }
        int temp = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] < temp) {
                temp = data[i];
            }
        }
        System.out.println();
        System.out.println("最小的数是"+temp);
    }
}
