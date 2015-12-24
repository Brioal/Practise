package brioal.test13.practise3;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.util.Date;

/**
 * Created by Brioal on 2015/12/23.
 */
public class DataChange {
    private int send_port ;
    private int receiver_port ;
    private InetAddress address;
    private DatagramPacket pack_send , pack_receive;
    private DatagramSocket socket_send , socket_receive;

    public DataChange(int send_port, int receiver_port) {
        this.send_port = send_port;
        this.receiver_port = receiver_port;
        try {
            address = InetAddress.getByName("127.0.0.1");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public void send(String messahe) {
        try {
            byte data[] = messahe.getBytes();
            pack_send = new DatagramPacket(data, data.length, address, send_port);
            socket_send = new DatagramSocket();
            socket_send.send(pack_send);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive(JTextArea textArea, FileWriter writer) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    byte data[] = new byte[8129];
                    pack_receive = new DatagramPacket(data, data.length);
                    socket_receive = new DatagramSocket(receiver_port);

                } catch (SocketException e) {
                    e.printStackTrace();
                }
                String message = "";
                while (!message.equals("Chat End")) {
                    try {
                        socket_receive.receive(pack_receive);
                        message = new String(pack_receive.getData(), 0, pack_receive.getLength());
                        textArea.append(String.valueOf(pack_receive.getAddress()) + "\n");
                        textArea.append(message+"\n\n");
writer.write("收到："+String.valueOf(pack_receive.getAddress())+"时间："+new Date()+"内容："+message+"\n");
                        writer.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        } ;

        new Thread(runnable).start();

    }
}
