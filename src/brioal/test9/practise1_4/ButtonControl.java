package brioal.test9.practise1_4;

import brioal.test9.practise1_1.WindowCloser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by brioal on 15-11-26.
 */
public class ButtonControl extends Frame implements ActionListener {

    Button btnDisplay;
    Label lbMsg;

    public ButtonControl() {
        super("按钮控件演示程序");
        btnDisplay = new Button("显示消息");
        lbMsg = new Label(" ");
        add(btnDisplay, BorderLayout.NORTH);
        add(lbMsg);
        btnDisplay.addActionListener(this);
        setSize(200, 200);
        setVisible(true);
        addWindowListener(new WindowCloser());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("显示消息")) {
            btnDisplay.setLabel("隐藏消息");
            lbMsg.setText("你好！ 世界");

        } else if (e.getActionCommand().equals("隐藏消息")) {
            btnDisplay.setLabel("显示消息");
            lbMsg.setText(" ");
        }
    }

    public static void main(String[] args) {
        new ButtonControl();
    }
}
