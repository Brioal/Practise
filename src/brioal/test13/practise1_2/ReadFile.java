package brioal.test13.practise1_2;//package brioal.test13.pracrise1_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by brioal on 15-12-17.
 */
public class ReadFile extends JApplet implements ActionListener, Runnable {
    File file;
    JComboBox choice;
    JTextArea text;
    Thread thread;
    JButton button ;
    String item = null;
    URL url ;

    public void init() {
        choice = new JComboBox();
        thread = new Thread(this);
        int N = Integer.parseInt(getParameter("4"));
        for (int i = 1; i <=N; i++) {
            choice.addItem(getParameter(String.valueOf(i)));
        }
        button = new JButton("��ʼ��ȡ");
        text = new JTextArea(12, 20);
        setLayout(new FlowLayout());
        button.addActionListener(this);
        add(choice);
        add(button);
        add(text);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        text.setText(null);
        item = "" + choice.getSelectedItem();
        item = item.trim();
        if (!(thread.isAlive())) {
            thread = new Thread(this);
        }
        try {
            thread.start();

        } catch (Exception ex) {

        }

    }

    @Override
    public void run() {
        try{
            url = new URL(getCodeBase(), item);
            InputStream in = url.openStream();
            int n = -1;
            byte b[] = new byte[100];
            while ((n = in.read(b)) != -1) {
                String str = new String(b, 0, n);
                text.append(str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
