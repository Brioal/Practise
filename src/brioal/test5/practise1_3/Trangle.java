package brioal.test5.practise1_3;

/**
 * Created by brioal on 15-9-20.
 */
public class Trangle {
    double sideA, sideB, sideC;
    boolean flag;

    public Trangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
            System.out.println("我是一个三角形");
            flag = true;
        } else {
            System.out.println("我不是一个三角形");
            flag = false;
        }
    }

    public void jsmi() {
        if (flag) {
            double p = (sideA + sideB + sideC) / 2.0;
            double area = Math.sqrt((p * (p - sideA) * (p - sideB) * (p - sideC)));
            System.out.println("是一个三角形,能计算面积");
            System.out.println("面积使:" + area);
        } else {
            System.out.println("不是三角形,不能计算面积");
        }
    }

    public void set(double a, double b, double c) {
        sideA = a;
        sideB = b;
        sideC = c;
        if (a + b > c && a + c > a && b + c > a) {
            flag = true;
        } else {
            flag = false;
        }
    }
}



