package brioal.test3.practise3_1;

/**
 * Created by brioal on 15-9-10.
 */
public class Fibonacci {
    public static void main(String[] args) {
        int x = 1;
        int y = 0;
        int z = 0;
        for (int i = 1; i < 20; i++) {
            if (i > 1) {
                z = x + y;
                y = x;
                x = z;
            }
            System.out.println(x);
        }
    }
}
