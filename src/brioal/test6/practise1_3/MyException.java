package brioal.test6.practise1_3;

/**
 * Created by brioal on 15-10-6.
 */

public class MyException extends Exception {
    String mymsg = "我的异常信息";

    public MyException() {
        super("我自定义的异常");
    }

    public MyException(String mymsg) {
        super(mymsg);
    }

    public void Displayme() {
        System.out.println(mymsg);
    }
}

class ExceptionTest {
    public static void main(String[] args) {
        try {
            if (args[0].charAt(0) == 'A') {//判断是否第一个字符是'A'
                MyException exception = new MyException();
                throw exception; // 抛出异常
            } else {
                System.out.println(args[0]);
            }
        } catch (MyException e) { // 捕获异常
            System.out.println(e.getMessage());
            e.Displayme();
        }

    }
}

