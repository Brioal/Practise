package brioal.test13.practise1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by brioal on 15-12-17.
 */
public class Client {
    public static void main(String[] args) {
        try {
//            Socket soc = new Socket("127.0.0.1", 4001);
            Socket soc = new Socket("219.246.71.4", 4001);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("出入消息至服务器");
            String messgae = "";
            String temp;
            PrintStream ps = new PrintStream(soc.getOutputStream());
            while (!((temp = br.readLine()).equals("quit"))) {
                ps.println(temp);
            }
            ps.close();
            soc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
