package brioal.test3.practise1_2;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by brioal on 15-9-10.
 */
public class AppletTest extends Applet{
    public void paint(Graphics g){
        g.drawString("HelloWorld", 60, 60);
        g.drawOval(100, 100, 80, 80);
    }
}
