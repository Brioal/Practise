package brioal.test7.practise1_1;

import java.io.File;

/**
 * Created by brioal on 15-10-13.
 */

public class FileMethods {
    public static void main(String [] args) {
        if (args.length == 0) {
            System.out.println("请输入文件名!");
            System.exit(0);
        }
        File f1 = new File(args[0]);
        System.out.println("文件名:" + f1.getName());
        System.out.println("路径:" + f1.getPath());
        System.out.println("绝对路径" + f1.getAbsolutePath());
        System.out.println(f1.exists() ? "文件存在" : "文件不存在");
        System.out.println(f1.isDirectory() ? "是目录" : "是文件");
        System.out.println(f1.isFile() ? "是普通文件" : "可能是命名管道");

        if (f1.canRead()) {
            System.out.println("可以读取此文件");
        }
        if (f1.canWrite()) {
            System.out.println("不能写入此文件");
        }

        System.out.println("此文件最后修改的事件是1970年1月1日后的"+f1.lastModified()+"秒");
    }

}
