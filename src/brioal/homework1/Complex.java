package brioal.homework1;

/**
 * Created by brioal on 15-10-8.
 */



public class Complex {
    private double Real; //实部
    private double Imag;// 虚部
    public static Complex result; // 存放结果

    // 无参构造
    public Complex() {

    }
    //带参构造
    public Complex(double real, double imag) {
        this.Real = real;
        this.Imag = imag;
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
    public  Complex add( Complex second) {
        return new Complex(Real + second.getReal(), Imag + second.getImag());
    }

    //    减法 (a+bi)-(c+di) = (a-c) + (b-d)i
    public  Complex sub(Complex second) {
        result = new Complex(Real - second.getReal(), Imag - second.getImag());
        return result;
    }

    //    乘法 (a+bi)*(c+di) = (ac-bd) + (ad+bc)i
    public  Complex mul(Complex complex) {
        result = new Complex(Real* complex.getReal() - Imag * complex.getImag(),Real* complex.getImag() + Imag * complex.getReal());
        return result;
    }

    //    加法 (a+bi)+(c+di) = (ac-bd)/(c*c+d*d) + (bc-ad)/(c*c+d*d)i
    public  Complex div(Complex complex) {

        double real = (Real* complex.getReal() + Imag * complex.getImag()) / (Math.pow(complex.getReal(), 2) + Math.pow(complex.getImag(), 2));
        double image = (Imag * complex.getReal() - Real* complex.getImag()) / (Math.pow(complex.getReal(), 2) + Math.pow(complex.getImag(), 2));
        result = new Complex(real, image);
        return result;
    }

    public boolean equals(Complex obj) {
        return Real == obj.getReal() && Imag == obj.getImag();
    }

    @Override
    public String toString() {
        if (Imag < 0) {
            return getReal() + "" + getImag() + "i";
        }
        return String.valueOf(Real) + "+" + getImag() + "i";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static String  getDesigner() {
        return "设计者:黄俊 学号:320130937631 班级: 13计算机一班";
    }
}

