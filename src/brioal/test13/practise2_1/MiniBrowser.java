package brioal.test13.practise2_1;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brioal on 2015/12/23.
 */
public class MiniBrowser extends JFrame implements ActionListener , Runnable {


    JButton button ;
    URL url ;
    JTextField text ;
    JEditorPane editorPane ;
    byte b[] = new byte[128];
    Thread thread ;

    public MiniBrowser() {
        text = new JTextField(20);
        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        button = new JButton("确定");

        button.addActionListener(this);
        thread = new Thread(this);
        JPanel p = new JPanel();
        p.add(new JLabel("输入网址 ："));
        p.add(text);
        p.add(button);
        Container con = getContentPane();
        con.add(new JScrollPane(editorPane), BorderLayout.CENTER);
        con.add(p, BorderLayout.NORTH);
        setBounds(60, 60, 560, 460);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editorPane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        editorPane.setPage(e.getURL());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        });
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(thread.isAlive())) {
            thread = new Thread(this);

        }
        try {
            thread.start();
        } catch (Exception e1) {
            text.setText("我正在读取"+url);
        }

    }

    @Override
    public void run() {
        int n = -1 ;
        editorPane.setText(null);
        editorPane.setContentType("text/html");
        try {
            url = new URL(text.getText().trim());
            editorPane.setPage(url);
        } catch (MalformedURLException e) {
            text.setText("+e1");
        } catch (IOException e) {
            text.setText("" + e);
        }
    }

    public static void main(String[] args) {
        new MiniBrowser();
    }
}
