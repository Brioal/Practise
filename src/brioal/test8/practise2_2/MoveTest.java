package brioal.test8.practise2_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Null on 2015/10/22.
 */
public class MoveTest {
    public static void main(String[] args) {
        try {
            Path source = Paths.get("image.png");
            Path target = Paths.get("data/image.png");
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The file image.png has moved to data/image.png");
    }
}
