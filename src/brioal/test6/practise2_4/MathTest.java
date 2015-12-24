package brioal.test6.practise2_4;

/**
 * Created by brioal on 15-10-6.
 */

public class MathTest {
    public static void main(String[] args) {
        System.out.println("PI=" + Math.PI);
        System.out.println("E=" + Math.E);
        System.out.println("ceil(2.3)=" + Math.ceil(2.4));//返回大于等于传入值的最小double值
        System.out.println("abs(-2.3)=" + Math.abs(-2.3));//返回绝对值
        System.out.println("sqrt(2)=" + Math.sqrt(2));//返回正确舍入的平方根
        System.out.println("random()=" + Math.random());//返回随机数
        System.out.println("sin(3.14/6=" + Math.sin(3.14 / 6));//正炫函数
        System.out.println("exp(1)=" + Math.exp(1));
        System.out.println("log(2.71828" + Math.log(2.71828)); // 以e为底的传入值的对数
        System.out.println("pow(2,3)=" + Math.pow(2, 3));//2的3次方
        System.out.println("toDegress(3.1415926/6)=" + Math.toDegrees(Math.PI / 6));//弧度值转角度值
        System.out.println("cbrt(8)="+Math.cbrt(8));//开立方根
    }

}
