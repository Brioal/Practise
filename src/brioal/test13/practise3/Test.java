package brioal.test13.practise3;

import java.io.File;

/**
 * Created by Brioal on 2015/12/24.
 */
public class Test {
    public static void main(String[] args) {
        new ChatFrame(5408, 9527, "���촰��A", new File("data/A_log.txt"));
        new ChatFrame(9527, 5408, "���촰��B", new File("data/B_log.txt"));
    }
}
