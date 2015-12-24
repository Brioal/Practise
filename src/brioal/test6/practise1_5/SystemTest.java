package brioal.test6.practise1_5;

import java.util.Properties;

/**
 * Created by brioal on 15-10-6.
 */

public class SystemTest {
    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        String path = System.getenv("Path");//获取path变量
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Properties myprop = System.getProperties();//创建系统变量对象

        System.out.println("Version:" + myprop.getProperty("java.version"));//输出虚拟机版本
        System.out.println("java home:" + myprop.getProperty("java.home"));//输出虚拟机home路径
        System.out.println("path:"+path);
        long endtime = System.currentTimeMillis();
        System.out.println("Spent time:"+(endtime-starttime));
    }

}
