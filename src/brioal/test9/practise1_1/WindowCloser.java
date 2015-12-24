package brioal.test9.practise1_1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by brioal on 15-10-8.
 */

public class WindowCloser extends WindowAdapter {
    public void WindowClosing(WindowEvent event) {

        System.exit(0);
    }


}
