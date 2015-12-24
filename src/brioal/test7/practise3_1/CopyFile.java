package brioal.test7.practise3_1;

import java.io.*;

/**
 * Created by brioal on 15-10-14.
 */

public class CopyFile {

    public CopyFile(String filenameFrom, String filenaemTo) {
        //带资源的try catch 运行结束时会自动释放资源
        try (FileReader reader = new FileReader(filenameFrom);
             BufferedReader br = new BufferedReader(reader);
             FileWriter writer = new FileWriter(filenaemTo);
             BufferedWriter bw = new BufferedWriter(writer)
        ) {
            String str = "";
            int i = 1 ;
            while ((str = br.readLine()) != null) {
                str = i+": " + str;
                i++;
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        CopyFile copyFile = new CopyFile("CopyFile.java","CopyFile.txt");
    }


}
