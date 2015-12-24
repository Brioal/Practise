package brioal.test4.practise2_1;

/**
 * Created by brioal on 15-9-13.
 */
//抽象三个类,分别位为Trange,Lader , Circle , 添加相应的getAndSet方法,计算面积各周长
class Trangle {
    double sideA;
    double sideB;
    double sideC;
    double area;
    double length;
    boolean flag;

    public Trangle(double A, double B, double C) {
        if ((A + B) > C && (C + B) > A && (A + C) > B) {
            this.sideA = A;
            this.sideB = B;
            this.sideC = C;

            flag = true;
        } else {
            flag = false;
        }
    }

    public double getLength() {
        if (flag) {
            return sideA + sideB + sideC;

        } else {
            System.out.println("不是三角形,不能计算周长");
            return 0;
        }
    }

    public double getArea() {
        if (flag) {
            double p = (sideA + sideB + sideC) / 2.0;
            area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
            return area;
        } else {
            System.out.println("不是三角形,不能计算面积");
            return 0;
        }
    }

    public void setSide(double A, double B, double C) {
        if ((A + B) > C && (C + B) > A && (A + C) > B) {
            this.sideA = A;
            this.sideB = B;
            this.sideC = C;

            flag = true;
        } else {
            System.out.println("不能组成三角形");

            flag = false;
        }
    }
}

class Lader {
    double above;
    double button;
    double height;
    double area;

    public Lader(double above, double button, double height) {
        this.above = above;
        this.button = button;
        this.height = height;
    }

    public double getArea() {
        return (above + button) * height / 2;
    }
}

class Circle {
    double radius,area;

    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 0 ;
        }
    }

    public double getArea() {
        return Math.PI*radius*radius;
    }

    public double getLength() {
        return 2*Math.PI*radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("周长不能为负数");
        }
    }
}


public class AreaAndLength {
    public static void main(String[] args) {
        double length , area ;
        Circle circle;
        Trangle trangle ;
        Lader lader ;

        circle = new Circle(20);
        trangle = new Trangle(3, 4, 5);
        lader = new Lader(20, 40, 10);

        length = circle.getLength();
        System.out.println("园的周长为"+length);
        area = circle.getArea();
        System.out.println("园的面积为"+area);

        System.out.println();
        length = trangle.getLength();
        System.out.println("三角形的周长为"+length);
        area = trangle.getArea();
        System.out.println("三角形的面积为"+area);
        System.out.println();
        area = lader.getArea();
        System.out.println("梯形的面积为"+area);

    }

}
