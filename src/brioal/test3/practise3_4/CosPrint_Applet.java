package brioal.test3.practise3_4;

import java.applet.Applet;
import java.awt.*;

/**
 * 3-3
 * 输出90度以内的各个值的sin
 * Created by brioal on 15-9-13.
 */
public class CosPrint_Applet extends Applet{
    public void paint(Graphics graphics) {
        for (int i = 30; i <= 60; i++)
        {
            graphics.drawString("Cos(" + i + ")= " + Math.cos(i * Math.PI / 180),10,10*(i-30));
        }
    }
}
