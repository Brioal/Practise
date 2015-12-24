package brioal.test8.practise2_1;

import brioal.test6.practise1_5.SystemTest;

import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Created by Null on 2015/10/22.
 */
public class PrintCalc {
    public static void main(String[] args) {
        PrintCalc app = new PrintCalc();
        try {
            app.readAndPrint();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readAndPrint() throws IOException {
        PushbackInputStream f = new PushbackInputStream(System.in, 3);
        int c, c1, c2;
        while ((c = f.read()) != 'q') {
            switch (c) {
                case '.':
                    System.out.print((char) c);
                    if ((c1 = f.read()) == '0') {
                        if ((c2 = f.read()) == '0') {
                            System.out.println("**");
                        } else {
                            f.unread(c2); //推回一个字符并赋值
                            f.unread(c1);
                        }
                    } else {
                        f.unread(c1);
                    }

                    break;
                default:
                    System.out.print((char) c);
                    break;

            }
        }
        f.close();
    }
}
