package brioal.test5.practise3_2;

/**
 * Created by brioal on 15-10-6.
 */

public class MyComplex {
    private double Real; //实部
    private double Imag;// 虚部
    public static MyComplex result; // 存放结果

    //带参构造
    public MyComplex(double real, double imag) {
        Real = real;
        Imag = imag;
    }

    public double getReal() {
        return (double) Real;
    }

    public void setReal(double real) {
        Real = real;
    }

    public double getImag() {
        return Imag;
    }

    public void setImag(double imag) {
        Imag = imag;
    }

    //    加法 (a+bi)+(c+di) = (a+c) + (b+d)i
    public static MyComplex add(MyComplex first, MyComplex second) {
        return new MyComplex(first.getReal() + second.getReal(), first.getImag() + second.getImag());
    }

//    减法 (a+bi)-(c+di) = (a-c) + (b-d)i
    public static MyComplex sub(MyComplex first, MyComplex second) {
        result = new MyComplex(first.getReal() - second.getReal(), first.getImag() - second.getImag());
        return result;
    }

//    乘法 (a+bi)*(c+di) = (ac-bd) + (ad+bc)i
    public static MyComplex mul(MyComplex first, MyComplex complex) {
        result = new MyComplex(first.getReal() * complex.getReal() - first.getImag() * complex.getImag(), first.getReal() * complex.getImag() + first.getImag() * complex.getReal());
        return result;
    }

    //    加法 (a+bi)+(c+di) = (ac-bd)/(c*c+d*d) + (bc-ad)/(c*c+d*d)i
    public static MyComplex div(MyComplex first, MyComplex complex) {

        double real = (first.getReal() * complex.getReal() + first.getImag() * complex.getImag()) / (Math.pow(complex.getReal(), 2) + Math.pow(complex.getImag(), 2));
        double image = (first.getImag() * complex.getReal() - first.getReal() * complex.getImag()) / (Math.pow(complex.getReal(), 2) + Math.pow(complex.getImag(), 2));
        result = new MyComplex(real, image);
        return result;
    }

    public boolean equals(MyComplex obj) {
        return Real == obj.getReal() && Imag == obj.getImag();
    }

    @Override
    public String toString() {
        if (Imag < 0) {
            return getReal() + "" + getImag() + "i";
        }
        return String.valueOf(Real) + "+" + getImag() + "i";
    }

}
