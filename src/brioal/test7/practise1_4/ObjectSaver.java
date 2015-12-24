package brioal.test7.practise1_4;


import java.io.*;
import java.util.Date;

/**
 * Created by brioal on 15-10-13.
 */

public class ObjectSaver {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objectFile.obj"));
        String obj1 = "hello";
        Date obj2 = new Date();
        Student obj3 = new Student("张三", 20);
        out.writeObject(obj1);
        out.writeObject(obj2);
        out.writeObject(obj3);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("objectFile.obj"));
        System.out.println("字符串对象");
        String obj11 = (String) in.readObject();
        System.out.println("obj11:" + obj11);
        System.out.println("obj11==obj1:" + (obj1 == obj11));
        System.out.println("obj11.equals(obj1):" + obj11.equals(obj1));
        System.out.println("\nDate对象");
        Date obj22 = (Date) in.readObject();
        System.out.println("obj22:" + obj22);
        System.out.println("obj22==obj2:" + (obj22 == obj2));
        System.out.println("obj22.equals(obj2):" + (obj22.equals(obj2)));
        System.out.println("\nStudent对象");
        Student obj33 = (Student) in.readObject();
        System.out.println("obj33:" + obj33);
        System.out.println("obj33==obj3:" + (obj33 == obj3));
        System.out.println("obj33.equals(obj3):" + (obj33.equals(obj3)));
        in.close();
    }

}

class Student  implements Serializable{
    private String Name;  // 学号属性
    private int Age;//   成绩属性

    public Student() {
    }

    //带参构造
    public Student(String name,  int age) {
        Name = name;
        Age = age;
        System.out.println("带两个参数的构造方法!");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.Name.equals(other.Name) && (this.Age == other.Age)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Name="+Name+",Age = "+Age;
    }
}
