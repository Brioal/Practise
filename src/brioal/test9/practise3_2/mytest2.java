package brioal.test9.practise3_2;

import brioal.test9.practise1_1.WindowCloser;

import java.awt.*;
import java.awt.event.*;

class mycanvas extends Canvas {
    private int flag;
    private int x, y;

    mycanvas() {
        flag = 0;
    }

    public void setFlag(int i) {
        flag = i;
    }

    public int getFlag() {
        return flag;
    }

    public void paint(Graphics g) {
        g.drawLine(1, 1, 400, 1);
        g.drawLine(1, 1, 1, 220);
        switch (flag) {
            case 1:
                for (int i = 0; i <= 360; i++) {
                    x = i;
                    y = 110 - (int) (100 * Math.sin(x * 3.1415926 / 180.0));
                    g.drawLine(x, y, x, y);
                }
                break;
            case 2:
                for (int i = 0; i <= 360; i++) {
                    x = i;
                    y = 110 - (int) (100 * Math.cos(x * 3.1415926 / 180.0));
                    g.drawLine(x, y, x, y);
                }
                break;
            case 3:
                System.exit(0);

            default:
                break;
        }
    }
}

public class mytest2 extends Frame {
    Panel p1;
    Button b1, b2, b3, b4;
    mycanvas mc;

    mytest2() {
        setTitle("画图演示");
        mc = new mycanvas();
        b1 = new Button("SIN");
        b2 = new Button("COS");
        b3 = new Button("EXIT");
//       b4=new Button("SQRT");
        p1 = new Panel();
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
//       p1.add(b4);
        myListener m1 = new myListener();
        b1.addActionListener(m1);
        b2.addActionListener(m1);
        b3.addActionListener(m1);
//       b4.addActionListener(m1);
        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(mc, BorderLayout.CENTER);
    }

    private class myListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                mc.setFlag(1);
                mc.repaint();
            }
            if (e.getSource() == b2) {
                mc.setFlag(2);
                mc.repaint();
            }
            if (e.getSource() == b3) {
                mc.setFlag(3);
                mc.repaint();
            }

        }
    }

    public static void main(String[] args) {
        mytest2 my = new mytest2();
        my.setSize(400, 300);
        my.setVisible(true);
        my.addWindowListener(new WindowCloser());
    }
}