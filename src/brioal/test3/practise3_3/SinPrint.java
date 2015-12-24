package brioal.test3.practise3_3;

/**
 * 3-3
 * 输出90度以内的各个值的sin
 * Created by brioal on 15-9-13.
 */
public class SinPrint {
    public static void main(String[] args) {
        for (int i = 0; i <= 90; i++) {
            System.out.println("Sin("+i+")= "+Math.sin(i*Math.PI/180));
        }
    }

}
