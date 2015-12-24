package brioal.test11.practise3_1;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Random;

/**
 * Created by brioal on 15-12-10.
 */
//public class Actions extends Applet {
public class Actions extends JFrame {
    private int x_hor;
    private int y_ver;
    private int x_image;
    private int y_image;
    private int currentImage = 0;
    private int screenWidth, screenHeight;

    private String[] images = new String[]{
            "data/image_01.jpg",
            "data/image_02.jpg",
            "data/image_03.jpg",
            "data/image_04.jpg",
            "data/image_05.jpg",
            "data/image_06.jpg"
    };


    public Actions() {
        screenWidth = 500;
        screenHeight = 500;
        x_image = 0;
        y_image = 10;
        x_hor = 0;
        y_ver = 40;
        Runnable draw_hor = new Runnable() {
            @Override
            public void run() {
                while (x_hor <= screenWidth) {
                    x_hor++;
                    y_ver++;
                    try {
                        Thread.sleep(100);
                        repaint();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        };
        Runnable draw_image = new Runnable() {
            @Override
            public void run() {
                while (x_image <= screenWidth - 200 && y_image <= screenHeight - 200) {
                    x_image += 5;
                    y_image += 5;
                    currentImage++;
                    currentImage = currentImage % 6;
                    try {
                        Thread.sleep(500);
                        update(getGraphics());
//                        repaint();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };


        new Thread(draw_hor).start();
        new Thread(draw_image).start();
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void update(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(x_image, y_image, 200, 200);
        g.setColor(getForeground());
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(0, 60, x_hor, 60);
        g.drawLine(40, 20, 40, y_ver);
        g.drawImage(new ImageIcon(images[currentImage], null).getImage(), x_image, y_image, 200, 200, this);


    }

    public static void main(String[] args) {
        new Actions();
    }


}
