package brioal.test9.practise1_2;

import brioal.test9.practise1_1.WindowCloser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by brioal on 15-10-8.
 */

public class ColorChanger extends Frame {
    private Color color = Color.RED;
    private int times;

    public ColorChanger(String title) {
        super(title);
        Button button = new Button("Change Color");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = (color == Color.RED) ? Color.GREEN : Color.RED;
                repaint();
            }
        });
        add(button, BorderLayout.NORTH);
        setSize(300, 300);
        setVisible(true);
        addWindowListener(new WindowCloser());
    }

    public void update(Graphics graphics) {
        super.update(graphics);
        System.out.println("call update" + (++times) + "times");
    }

    public void paint(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(0,0,300,300);
    }

    public static void main(String[] args) {
        new ColorChanger("Hello");
    }

}
