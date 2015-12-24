package brioal.test4.practise1_2;


import brioal.test4.practise1_1.Person;

/**
 * Created by brioal on 15-9-13.
 */
//数组测试
//测试数组内放置对象和数据
public class ArrayTest {
    public static void main(String[] args) {
        int[] a;
        Person[] p;

        a = new int[10];
        p = new Person[3];

        for (int i = 0; i < 3; i++) {
            a[i] = (int) (100 * Math.random());
        }

        p[0] = new Person(10, "张三", 'M');
        p[1] = new Person(20, "李四", 'F');
        p[2] = new Person(30, "王五", 'M');


        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]= " + a[i]);
        }
        System.out.println();
        System.out.println(p[0] + "\n" + p[1] + "\n" + p[2]);
        System.out.println();
        System.out.println("a中元素的个数为" + a.length);
        System.out.println("p中元素的个数为" + p.length);

    }
}
