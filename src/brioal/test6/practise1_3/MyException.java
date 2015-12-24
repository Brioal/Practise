package brioal.test6.practise1_3;

/**
 * Created by brioal on 15-10-6.
 */

public class MyException extends Exception {
    String mymsg = "�ҵ��쳣��Ϣ";

    public MyException() {
        super("���Զ�����쳣");
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
            if (args[0].charAt(0) == 'A') {//�ж��Ƿ��һ���ַ���'A'
                MyException exception = new MyException();
                throw exception; // �׳��쳣
            } else {
                System.out.println(args[0]);
            }
        } catch (MyException e) { // �����쳣
            System.out.println(e.getMessage());
            e.Displayme();
        }

    }
}

