package brioal.test3.practise1_1;

/**
 * Created by brioal on 15-9-10.
 */
public class Shiyan3_1_1 {
    public static void main(String[] args) {

        double mass = 5.98E24;
        double radius = 6.370856E6;
        double volume = 4*Math.pow(radius,3)/3;
        double density=mass/volume;

        System.out.println("我们已经知道地球的平均半径位6370.856Km");
        System.out.println("我们也知道公认的地球质量位5.98*10^24kg");
        System.out.println("我们就可以使用数学公式计算地球的平均密度为:");
        System.out.println(density+"(千克/立方米)");
    }
}
