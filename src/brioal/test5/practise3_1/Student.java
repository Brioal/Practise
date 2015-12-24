package brioal.test5.practise3_1;

/**
 * Created by brioal on 15-10-6.
 */

public class Student extends Person {
    private String Id;  // 学号属性
    private int Score;//   成绩属性

    public Student() {
    }

    //带参构造
    //调用super来赋值
    public Student(String name, String id, int age, char sex, int score) {
        super(age, name, sex);
        Id = id;
        Score = score;
    }

    public void Diaplay() {
        System.out.println("名字:" + getName());
        System.out.println("学号:" + Id);
        System.out.println("年龄:" + getAge());
        System.out.println("性别:" + getSex());
        System.out.println("成绩:" + Score);
    }

}
