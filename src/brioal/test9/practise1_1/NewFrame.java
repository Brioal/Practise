package brioal.test9.practise1_1;

import java.awt.*;

/**
 * Created by brioal on 15-10-8.
 */

public class NewFrame extends Frame {
    static final String title = "GUI窗口标题";

    public NewFrame(String s) {
        super(s);
        setSize(200, 200);
        setVisible(true);
        addWindowListener(new WindowCloser());

    }

    public NewFrame() {
        super(title);
    }

    public static void main(String[] args) {
        NewFrame newFrame = new NewFrame("基本GUI编程");
    }

}
