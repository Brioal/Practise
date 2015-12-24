package brioal.test9.practise2_2;

import brioal.test9.practise1_1.WindowCloser;

import java.awt.*;
import java.awt.event.*;

public class ActionTest extends Frame {
    public ActionTest() {
        super("�����¼�");
        Button b1 = new Button("��ɫ");
        Button b2 = new Button("��ɫ");
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        MyListener mylistener = new MyListener();
        b1.addActionListener(mylistener);
        b2.addActionListener(mylistener);
        addWindowListener(new WindowCloser());

    }

    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();
            if (str.equals("��ɫ")) {
                setBackground(Color.red);
            } else {
                setBackground(Color.blue);
            }
        }
    }

    public static void main(String[] args) {
        ActionTest myapp = new ActionTest();
        myapp.setSize(300, 300);
        myapp.setVisible(true);
    }
}