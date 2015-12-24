package brioal.test8.practise3_1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Null on 2015/10/29.
 */
public class PhoneInfoTest {
    public static void main(String[] args) throws IOException {
        PersonInfo info = new PersonInfo();
        Scanner keyin = new Scanner(System.in);
        System.out.println("请输入名片信息:");
        System.out.print("工作单位:");        info.setSchool(keyin.nextLine());
        System.out.print("姓名:");        info.setName(keyin.nextLine());
        System.out.print("称呼:");        info.setId(keyin.nextLine());
        System.out.print("电话:");        info.setTel(keyin.nextLine());
        System.out.print("手机:");        info.setPhone(keyin.nextLine());
        System.out.print("邮箱:");        info.setMail(keyin.nextLine());
        System.out.println(info.getId());
        System.out.println(info.getName());
        info.Save();
        System.out.println(info);

    }
}
