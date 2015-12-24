package brioal.test9.practise1_1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by brioal on 15-10-8.
 */

public class Frame1 {
    public static void main(String[] args) {
        //传入String来设置标题
        Frame frame = new JFrame("GUI窗口标题");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.addWindowListener(new WindowCloser());
    }

}
