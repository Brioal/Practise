package brioal.test7.practise1_2;

import java.io.*;

/**
 * Created by brioal on 15-10-13.
 */

public class ByteStreamTest {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("data.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
            dataOutputStream.writeByte(-12);
            dataOutputStream.writeLong(12);
            dataOutputStream.writeChar('A');
            dataOutputStream.writeUTF("中国");
            dataOutputStream.close();

            InputStream inputStream = new FileInputStream("data.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readLong());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readUTF());

            dataInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
