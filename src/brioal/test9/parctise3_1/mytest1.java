package brioal.test9.parctise3_1;

import brioal.test9.practise1_1.WindowCloser;

import java.awt.*;
import java.awt.event.*;

public class mytest1 extends Frame {
    TextField f1;

    public mytest1() {
        setTitle("文本框Action测试");
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Button b1 = new Button("确定");
        Button b2 = new Button("清除");
        Label l1 = new Label("姓名：");
        f1 = new TextField(40);
        p1.setLayout(new FlowLayout());
        p1.add(l1);
        p1.add(f1);
        p2.add(b1);
        p2.add(b2);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        MyListener mylistener = new MyListener();
        b1.addActionListener(mylistener);
        b2.addActionListener(mylistener);
        addWindowListener(new WindowCloser());
    }

    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();
            String name = f1.getText();
            if (str.equals("确定")) {
                f1.setText("你好，" + name + "欢迎你使用java编程");
            } else {
                f1.setText("");
            }
        }
    }

    public static void main(String[] args) {
        mytest1 my = new mytest1();
        my.setSize(400, 150);
        my.setVisible(true);
    }
}