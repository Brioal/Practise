package brioal.test8.practise1_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Scanner;

/**
 * Created by Null on 2015/10/22.
 */
public class FileLockTest {
    public static void main(String[] args) throws IOException {
        File file = new File("data/out.txt");
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel fc = fos.getChannel();
        FileLock fileLock = fc.tryLock(); //视图将文件锁定,如果文件没被其他调用,那么就会获取到返回的FileLock(文件锁定)对象,如果文件被其他程序使用,则返回null,出现空指针错误
        if (fileLock.isValid()) { //测试文件锁定对象的有效性
            System.out.println(file.getName()+" is locked");
        }
        Scanner keyin = new Scanner(System.in);
        String msg = keyin.nextLine();
        fos.write(msg.getBytes());
        fileLock.release(); //关闭用于锁定文件的通道
        System.out.println(file.getName() + " is released");
        fc.close();
        fos.close();

    }
}
