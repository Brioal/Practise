package brioal.test3.practise2_3;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by brioal on 15-9-10.
 */
public class FirstApplet extends Applet {
    public void paint(Graphics graphics) {
        for (int i = 1; i < 20; i++) {
            //参数分别位 字符串 横坐标 纵坐标
            graphics.drawString("sqrt(" + i + ")" + Math.sqrt(i), 20, 20 + i * 20);

        }

    }
}
