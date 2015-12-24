package brioal.test3.practise3_2;

/**
 * Created by brioal on 15-9-10.
 */
public class PrintS {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <10 ; j++) {
                if (j <= i) {
                    System.out.print(i + "*" + j + "=" + i * j+"  ");
                }
            }
            System.out.println(" ");
        }
    }
}
