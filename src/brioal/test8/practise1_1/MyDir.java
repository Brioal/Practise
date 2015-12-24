package brioal.test8.practise1_1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Null on 2015/10/22.
 */
public class MyDir {
    public static void main(String[] args) {
        if (args.length < 1) {  //��û�������в���
            System.out.println("Usage :java MyDir [��չ��]");
            System.exit(0);
        }

        Path dirpath = Paths.get(args[0]);
        DirectoryStream<Path> directory = null;
        try {
            if (args.length == 1) { // ���ֻ����һ������,��˲�����������Ŀ¼
                directory = Files.newDirectoryStream(dirpath);

            } else { // ����������,���������Ŀ¼���ض���׺
                directory = Files.newDirectoryStream(dirpath, "*{" + args[1] + "}");
            }
            for (Path p : directory) {
                System.out.println(p.getFileName());
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Invalid path specified:" + args[0]);
        }finally {

            try {
                if (directory != null) {
                    directory.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
