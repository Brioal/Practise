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
        if (args.length < 1) {  //即没有命令行参数
            System.out.println("Usage :java MyDir [扩展名]");
            System.exit(0);
        }

        Path dirpath = Paths.get(args[0]);
        DirectoryStream<Path> directory = null;
        try {
            if (args.length == 1) { // 如果只传入一个参数,则此参数用于输入目录
                directory = Files.newDirectoryStream(dirpath);

            } else { // 如果参数完成,则输入的是目录和特定后缀
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
