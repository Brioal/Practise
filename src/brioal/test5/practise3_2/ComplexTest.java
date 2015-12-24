package brioal.test5.practise3_2;

/**
 * Created by brioal on 15-10-6.
 */

public class ComplexTest {
    public static void main(String[] args) {
        MyComplex m1 = new MyComplex(3.4, 8.0);
        MyComplex m2 = new MyComplex(3.4, 8.0);
        System.out.println("m1=" + m1);
        System.out.println("m2=" + m2);
        System.out.println("m1==m3=" + (m1 == m2));
        System.out.println("m1.equal(m2)=" + m1.equals(m2));

        MyComplex m3 = new MyComplex(4.4, -8.9);
        System.out.println("m3=" + m3);
        MyComplex m4 = MyComplex.add(m1, m3);
        MyComplex m5 = MyComplex.sub(m2, m3);
        MyComplex m6 = MyComplex.mul(m1, m2);
        MyComplex m7 = MyComplex.div(m1, m2);
        System.out.println("m1+m3=" + m4);
        System.out.println("m2-m3=" + m5);
        System.out.println("m1*m2=" + m6);
        System.out.println("m1/m2=" + m7);

    }


}
