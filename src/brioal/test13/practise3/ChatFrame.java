package brioal.test13.practise3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Brioal on 2015/12/23.
 */
public class ChatFrame extends JFrame implements Ui, ActionListener {
    private DataChange dataChange;
    private JTextField inMessage;
    private JTextArea showMessage;
    private JButton btnSend;
    private FileWriter fw ;
    private String title = "聊天窗口";
//    private BufferedWriter writer ;


    public ChatFrame(int send_port, int receive_port, String title,File file) {
        this.title = title;
        initViews();
        addViews();
        setViews();
        try {
            fw = new FileWriter(file);
//            writer = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataChange = new DataChange(send_port, receive_port);
        dataChange.receive(showMessage, fw);
        AWTEventListener listener = new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                KeyEvent e=(KeyEvent)event;
                if(e.getKeyChar()==KeyEvent.VK_ENTER&&e.getID()==KeyEvent.KEY_RELEASED){
                    send();

                }
            }
        } ;
        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK);

    }




    @Override
    public void initViews() {
        inMessage = new JTextField(20);
        showMessage = new JTextArea(20, 20);
        btnSend = new JButton("发送消息");
    }

    @Override
    public void setViews() {
        btnSend.addActionListener(this);
        setTitle(title);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void addViews() {
        showMessage.setLineWrap(true);
        Box box1 = Box.createHorizontalBox();
        box1.add(inMessage);
        box1.add(btnSend);
        Box box2 = Box.createVerticalBox();
        JScrollPane scrollPane = new JScrollPane(showMessage);
        box2.add(scrollPane);
        box2.add(box1);
        getContentPane().add(box2);
    }

    public void send() {
        String message = inMessage.getText().toString();
        if (!message.equals("")) {
            dataChange.send(message);
            inMessage.setText("");
            showMessage.append("我："+"\n"+message+"\n\n");
            try {
//                writer.write("发送："+"时间："+new Date()+"内容："+message+"\n");
//                writer.flush();
                fw.write("发送："+"时间："+new Date()+"内容："+message+"\n");
                fw.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       send();
    }


}
