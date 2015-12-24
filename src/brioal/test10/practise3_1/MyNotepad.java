package brioal.test10.practise3_1;

import brioal.test9.practise1_1.WindowCloser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by brioal on 15-12-6.
 */
public class MyNotepad extends JFrame implements ActionListener {
    final JMenu[] menus = new JMenu[]{
            new JMenu("文件"),
            new JMenu("编辑"),
            new JMenu("文本颜色"),
            new JMenu("帮助")
    };
    final JMenuItem[][] menuItems = new JMenuItem[][]{
            {
                    new JMenuItem("打开"),
                    new JMenuItem("保存"),
                    new JMenuItem("另存为"),
                    new JMenuItem("退出"),
            },
            {
                    new JMenuItem("复制"),
                    new JMenuItem("剪切"),
                    new JMenuItem("粘贴"),
            },
            {
                    new JMenuItem("红色"),
                    new JMenuItem("绿色"),
                    new JMenuItem("蓝色"),
                    new JMenuItem("自定义"),
            },
            {
                    new JMenuItem("帮助"),

            },
    };
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JFileChooser fileChooser;
    private String title;
    private JScrollPane scrollPane;

    public MyNotepad() {
        initViews();
        setViews();
        addViews();
    }

    public void initViews() {
        menuBar = new JMenuBar();
        for (int i = 0; i < menus.length; i++) {
            for (int j = 0; j < menuItems[i].length; j++) {
                menus[i].add(menuItems[i][j]);
                menuItems[i][j].addActionListener(this);
            }
            menuBar.add(menus[i]);
        }

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Allowed File", "txt", "java");
        fileChooser.setFileFilter(filter);

    }


    public void setViews() {
        this.addWindowListener(new WindowCloser());
        this.setJMenuBar(menuBar);
        this.setSize(400, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void addViews() {

        setContentPane(scrollPane);
    }

    //添加
    public void Open(File file) {
        int linecount = 1;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String str = "";
            StringBuffer buffer = new StringBuffer();
            while ((str = reader.readLine()) != null) {
                buffer.append(linecount++ + ":  " + str + "\n");
            }
            textArea.setText("");
            textArea.setText(buffer.toString());
            repaint();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //保存
    public void Save(File file) {
        File temp = new File("/tmp/temp.txt");
        String content = textArea.getText();
        try {
            FileWriter fw = new FileWriter(temp);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(content);
            writer.flush();
            writer.close();
            fw.close();
            FileReader fr = new FileReader(temp);
            BufferedReader reader = new BufferedReader(fr);
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            String str = "";
            while ((str = reader.readLine()) != null) {
                String s = str.split("\\d+:")[1] + "\n";
                writer.write(s);
            }
            writer.flush();
            temp.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //改变颜色
    public void ChangeColor(Color color) {
        System.out.println("Color");
        textArea.setForeground(color);
        repaint();
    }

    public static void main(String[] args) {
        new MyNotepad();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "打开":
                int i = fileChooser.showOpenDialog(null);
                if (i == fileChooser.APPROVE_OPTION) { //打开文件
                    Open(fileChooser.getSelectedFile());
                    title = fileChooser.getSelectedFile().getAbsolutePath();
                } else {
                    System.out.println("没有选中文件");
                }
                break;
            case "保存":
                Save(new File(title));
                break;
            case "另存为":
                int j = fileChooser.showSaveDialog(null);
                if (j == fileChooser.APPROVE_OPTION) { //保存文件

                    Save(fileChooser.getSelectedFile()); // 已新的文件名保存文件
                } else {
                    System.out.println("没有选中文件");
                }
                File file = fileChooser.getSelectedFile();
                Save(file);
                break;
            case "退出":
                System.exit(0);
                break;
            case "复制":
                textArea.copy();
                break;
            case "剪切":
                textArea.cut();
                break;
            case "粘贴":
                textArea.paste();
                break;

            case "红色":
                ChangeColor(Color.RED);
                break;
            case "绿色":
                ChangeColor(Color.GREEN);
                break;
            case "蓝色":
                ChangeColor(Color.BLUE);
                break;
            case "自定义":
                JColorChooser colorChooser = new JColorChooser(Color.black);
                Color color = JColorChooser.showDialog(colorChooser, "颜色选择器", null);
                ChangeColor(color);
                break;
            case "帮助":
                break;
        }
    }
}
