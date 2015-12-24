package brioal.test13.practise2_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Brioal on 2015/12/23.
 */
public class JsService {
    public static void main(String[] args) {
        ServerSocket service = null;
        ServiceThread thread ;
        Socket client = null;
        while (true) {
            try {
                service = new ServerSocket(9528);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("���ڼ���");
            }
            try {
                client = service.accept();
                System.out.println("�ͻ��ĵ�ַ��"+client.getInetAddress());
            } catch (IOException e) {
                System.out.println("���ڵȴ��ͻ�");
            }

            if (client != null) {
                new ServiceThread(client).start();
            } else {
                continue;
            }
        }
    }
}

class ServiceThread extends Thread{

    Socket socket ;
    DataOutputStream out = null ;
    DataInputStream in = null ;
    String s = null ;
    ServiceThread(Socket t) {
        socket = t ;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            double a =  0 , b = 0 , c = 0  ,area = 0 ;
            try {
                a = in.readDouble();
                b= in.readDouble();
                c = in.readDouble();
                double p = (a + b + c) / 2.0;
                area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                out.writeDouble(area);

            } catch (IOException e) {
                System.out.println("�ͻ��뿪");
                break;
            }
        }
    }
}
