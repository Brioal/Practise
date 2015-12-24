package brioal.test6.practise3_1;

/**
 * Created by brioal on 15-10-6.
 */

public class Calculator {


    public static void main(String[] args) {
        double first;
        double second;
        char op;
        double result = 0;

        try {
            first = Double.parseDouble(args[0]);
            op = args[1].charAt(0);
            second = Double.parseDouble(args[2]);
            if (op == '/' && second == 0) {
                throw new ArithmeticException();
            }
            switch (op) {
                case '+':
                    result = first + second;
                    break;
                case '-':
                    result = first - second;
                    break;
                case '*':
                    result = first * second;
                    break;
                case '/':
                    result = first / second;
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println("数学类异常,除数不能为0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("输入参数错误");
        } catch (NumberFormatException e) {
            System.out.println("输入字符错误");
        } finally {

            System.out.println("result=" + result);
            System.out.println("无论是产生异常都执行");
        }
    }

}
