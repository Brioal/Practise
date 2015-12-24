package brioal.test5.practise2_2;


/**
 * Created by brioal on 15-9-21.
 */
public class ComputerTime {
    public static void main(String[] args) {
        System.out.println("交通工具:" + args[0]);
        System.out.println("参数A:" + args[1]);
        System.out.println("参数B:" + args[2]);
        System.out.println("参数C:" + args[3]);

        double A = Double.parseDouble(args[1]);
        double B = Double.parseDouble(args[2]);
        double C = Double.parseDouble(args[3]);

        double v , t ;
        try {
            Common d =(Common) Class.forName("brioal.test5.practise2_2."+args[0]).newInstance();
            v = d.runTimer(A, B, B);
            t = 1000/v;
            System.out.println("平均速度:" + v + "km/h");
            System.out.println("运行事件:" + t + "小时");
        } catch (Exception e) {
            System.out.println("Class Not Found");
        }
    }
}
