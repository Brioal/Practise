package brioal.test10.practise2_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class GuessNumber extends JFrame implements ActionListener {
    int number;
    JTextField inputNumber;
    JLabel feedBack;
    JButton buttonGetNumber, buttonEnter;

    GuessNumber(String s) {
        super(s);
        buttonGetNumber = new JButton("得到一个随机数");
        feedBack = new JLabel("无反馈信息", JLabel.CENTER);
        feedBack.setBackground(Color.green);
        inputNumber = new JTextField("0", 5);
        buttonEnter = new JButton("确定");
        buttonEnter.addActionListener(this);
        buttonGetNumber.addActionListener(this);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 2));
        p.add(new JLabel("获取1-100内的随机数"));
        p.add(buttonGetNumber);
        p.add(new JLabel("输入您的猜测"));
        p.add(inputNumber);
        p.add(new JLabel("单机确定按钮"));
        p.add(buttonEnter);
        p.add(new JLabel("反馈信息："));
        p.add(feedBack);
        Container con = getContentPane();
        con.add(p);
        con.validate();
        setBounds(120, 125, 270, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 150, 150);
        setVisible(true);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == buttonGetNumber) {
            number = (int) (Math.random() * 100) + 1;
        } else if (e.getSource() == buttonEnter) {
            int guess = 0;
            try {
                guess = Integer.parseInt(inputNumber.getText());
                if (guess == number) {
                    feedBack.setText("猜对了");
                } else if (guess > number) {
                    feedBack.setText("猜大了");
                    inputNumber.setText(null);
                } else if (guess < number) {
                    feedBack.setText("猜小了");
                    inputNumber.setText(null);
                }
            } catch (NumberFormatException event) {
                feedBack.setText("请输入数字字符");
            }
        }
    }
}

class GuessExample {
    public static void main(String args[]) {
        new GuessNumber("猜数字小游戏");
    }
}
