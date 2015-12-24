package brioal.test7.practise1_3;

import java.io.*;

/**
 * Created by brioal on 15-10-13.
 */

public class FileConvert {


    public void readFile(String fileName) throws IOException {
        readFile(fileName, null);
    }

    //    从一个文件当初逐行读取字符串,并指定编码方式
    public void readFile(String fileName, String charsetName) throws IOException {
        InputStream in = new FileInputStream(fileName);
        InputStreamReader reader;
        if (charsetName == null) {
            reader = new InputStreamReader(in);
        } else {
            reader = new InputStreamReader(in, charsetName);
        }

        BufferedReader br = new BufferedReader(reader);
        String data = "";
        while ((data = br.readLine()) != null) {
            System.out.println(data);
        }
        br.close();
    }

    //    把一个文件中的字符复制到另一个文件当中,并进行编码转换
    public void copyFile(String from, String charsetFrom, String to, String charsetTo) throws IOException {
        InputStream in = new FileInputStream(from);
        InputStreamReader reader;
        if (charsetFrom == null) {
            reader = new InputStreamReader(in);
        } else {
            reader = new InputStreamReader(in, charsetFrom);
        }
        BufferedReader br = new BufferedReader(reader);

        OutputStream os = new FileOutputStream(to);
        OutputStreamWriter writer;
        if (charsetTo == null) {
            writer = new OutputStreamWriter(os);
        } else {
            writer = new OutputStreamWriter(os, charsetTo);
        }

        BufferedWriter bw = new BufferedWriter(writer);
        String data = "";
        while ((data = br.readLine()) != null) {
            if (data.contains("package brioal")) {

            } else {
                bw.write(data);
                bw.newLine();
            }

        }
        br.close();
        bw.close();

    }

    public static void main(String[] args) throws IOException {
        FileConvert myapp = new FileConvert();//创建对象
        System.out.println("本地默认编码-----------------------------------------------");
        myapp.readFile("test.txt");//已默认编码读取文件显示到控制台
        myapp.copyFile("test.txt", null, "unicode.txt", "Unicode");
        myapp.copyFile("test.txt", null, "utf8.txt", "UTF-8");

        System.out.println("默认编码打开unicode编码文件-----------------------------------------------");
        myapp.readFile("unicode.txt");
        System.out.println("utf-8编码打开UTF8编码文件-----------------------------------------------");
        myapp.readFile("utf8.txt", "UTF-8");

        // 自己添加用于测试GBK
        System.out.println("GBK编码测试-----------------------------------------------");
        myapp.copyFile("test.txt", null, "gbk.txt", "GBK");
        System.out.println("默认编码打开GBK编码文件-----------------------------------------------");
        myapp.readFile("gbk.txt");
        System.out.println("GBK编码打开GBK编码文件-----------------------------------------------");
        myapp.readFile("gbk.txt", "GBK");

    }

}

