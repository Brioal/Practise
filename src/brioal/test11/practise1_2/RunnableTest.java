package brioal.test11.practise1_2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by brioal on 15-12-16.
 */
public class RunnableTest extends JFrame implements Runnable {

    JLabel prompt1 = new JLabel("第一个子线程");
    JLabel prompt2 = new JLabel("第二个子线程");
    JTextField threadFirst = new JFormattedTextField(14);
    JTextField threadSecond = new JFormattedTextField(14);
    Thread thread1, thread2;
    int count1 = 0, count2 = 0;

    public RunnableTest() {
        super("线程测试");
//        setLayout(new FlowLayout());
        setLayout(new GridLayout(2, 2));
        add(prompt1);
        add(threadFirst);
        add(prompt2);
        add(threadSecond);
        pack();
    }

    public void start() {
        thread1 = new Thread(this, "FirstThread");
        thread2 = new Thread(this, "SecondeThread");
        thread1.start();
        thread2.start();

    }


    @Override
    public void run() {
        String currentRunning;
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            currentRunning = Thread.currentThread().getName();
            if (currentRunning.equals("FirstThread")) {
                count1++;
                threadFirst.setText("线程1第" + count1 + "次被调度");
            } else if (currentRunning.equals("SecondeThread")) {
                count2++;
                threadSecond.setText("线程2第" + count2 + "次被调度");
            }
        }
    }

    public static void main(String[] args) {
        RunnableTest myapp = new RunnableTest();
        myapp.setSize(300, 100);
        myapp.setVisible(true);
        myapp.start();
        myapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
