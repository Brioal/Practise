package brioal.test10.practise1_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by brioal on 15-12-3.
 */
public class Test extends JFrame {
    //    private ScrollPane pane ;
//    private TextArea area ;
    private Button button;

    public Test() {
        button = new Button("Open");
//        pane = new ScrollPane();
//        area = new TextArea();
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JFrame frame = new JFrame();

                JColorChooser colorChooser = new JColorChooser(Color.black);
                Color color = JColorChooser.showDialog(colorChooser, "颜色选择器", null);
//                JPanel panel = new JPanel();
//                frame.add(panel, BorderLayout.NORTH);
//                frame.add(colorChooser,BorderLayout.CENTER);
//                colorChooser.s
//                frame.setSize(300, 300);
//                frame.setVisible(true);
                button.setBackground(color);
                repaint();
//                update();
//                colorChooser.show();


            }
        });
//        pane.add(area,BorderLayout.NORTH);

        add(button);

//        add(pane);
        setSize(300, 300);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
}
