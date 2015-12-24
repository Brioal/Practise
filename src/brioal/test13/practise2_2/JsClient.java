package brioal.test13.practise2_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Brioal on 2015/12/23.
 */
public class JsClient extends JFrame implements Runnable, ActionListener {

    JButton connecton, jsbutton;
    JTextField inputA, inputB, inputC;
    JTextArea showResult;
    Socket socket;
    DataInputStream in = null;
    DataOutputStream out = null;
    Thread thread;


    public JsClient() {


        try {
            socket = new Socket();
            connecton = new JButton("���ӷ�����");
            jsbutton = new JButton("�������ε����");
            jsbutton.setEnabled(false);
            inputA = new JTextField("0", 12);
            inputB = new JTextField("0", 12);
            inputC = new JTextField("0", 12);
            Box boxV1 = Box.createVerticalBox();
            boxV1.add(new JLabel("�����A"));
            boxV1.add(new JLabel("�����B"));
            boxV1.add(new JLabel("�����C"));
            Box boxV2 = Box.createVerticalBox();
            boxV2.add(inputA);
            boxV2.add(inputB);
            boxV2.add(inputC);
            Box baseBox = Box.createHorizontalBox();
            baseBox.add(boxV1);
            baseBox.add(boxV2);
            Container con = getContentPane();
            con.setLayout(new FlowLayout());
            showResult = new JTextArea(8, 18);
            con.add(connecton);
            con.add(baseBox);
            con.add(jsbutton);
            con.add(new JScrollPane(showResult));
            jsbutton.addActionListener(this);
            connecton.addActionListener(this);
            thread = new Thread(this);
            setBounds(100, 100, 360, 310);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connecton) {
            if (socket.isConnected()) {

            } else {
                try {
                    InetAddress address = InetAddress.getByName("127.1.0.0");
                    InetSocketAddress socketAddress = new InetSocketAddress(address, 9528);
                    socket = new Socket(socketAddress.getHostString(), socketAddress.getPort());
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());
                    jsbutton.setEnabled(true);
                    thread.start();
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getSource() == jsbutton) {
            try {
                double a = Double.parseDouble(inputA.getText());
                double b = Double.parseDouble(inputB.getText());
                double c = Double.parseDouble(inputC.getText());
                if (a + b > c && a + c > b && b + c > a) {
                    out.writeDouble(a);
                    out.writeDouble(b);
                    out.writeDouble(c);
                } else {
                    inputA.setText("�������������������������");

                }
            } catch (IOException e1) {
                inputA.setText("�����������ַ�");

            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                double area = in.readDouble();
                showResult.append("\n�����ε����:\n" + area);
                showResult.setCaretPosition(showResult.getText().length());
            } catch (IOException e) {
                showResult.setText("��������ѶϿ�");
                jsbutton.setEnabled(false);
                break;
            }
        }
    }

    public static void main(String[] args) {
        JsClient win = new JsClient();
    }
}
