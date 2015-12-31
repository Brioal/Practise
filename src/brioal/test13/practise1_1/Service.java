package brioal.test13.practise1_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by brioal on 15-12-17.
 */
public class Service {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9527);
            Socket socket = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messgae = "";
            String temp;
            do {
                temp = br.readLine();
                if (temp == null) {
                    break;
                }
                System.out.println("�յ���Ϣ:" + temp);
                messgae = messgae + temp + "\n";
            } while (true);
            br.close();
            PrintStream ps = new PrintStream(new FileOutputStream("data/message.txt"));
            ps.println(messgae);
            ps.close();
            br.close();
            socket.close();
            System.out.println("�Ѵ洢��Ϣ,����ļ����!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
