package brioal.test7.practise2_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by brioal on 15-10-13.
 */

public class RandomTest {
    public static void main(String[] args) {
        File f = new File("RandomTest.java");
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(f,"r");
            long  l =randomAccessFile.length();
            char ch ;
            for (long i = l - 1; i >= 0; i--) {
                randomAccessFile.seek(i);
                ch = (char) randomAccessFile.read();
                System.out.print(ch);
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
