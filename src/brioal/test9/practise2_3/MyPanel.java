package brioal.test9.practise2_3;

import java.awt.*;
import java.awt.event.*;

class MyPanel extends Panel {
    String msg = "Pressed Key";

    public MyPanel() {
        MyKeyAdapter bAction = new MyKeyAdapter();
        addKeyListener(bAction);
    }

    public void paint(Graphics g) {
        g.setFont(new Font("����", Font.BOLD, 24));
        g.drawString(msg, 20, 50);
    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent kevent) {
            int keyCode = kevent.getKeyCode();
            msg = "Pressed Key :" + keyCode + "char :" + (char) keyCode;
            repaint();

        }

        public void keyReleased(KeyEvent kevent) {
            setBackground(Color.red);
            repaint();
        }

        public void keyTyped(KeyEvent kecent) {

        }
    }
}