package brioal.test4.practise1_1;

/**
 * Created by brioal on 15-9-13.
 */
public class Person {
    private int age = 0;
    private String name = null;
    private char sex = 'M';
    //空构造方法
    public Person(){
    }
    //全参数构造方法
    public Person(int age, String name, char sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public void introduce() {
        System.out.println("My name is " + name + "\tMy Age Is " + age);
        if (sex == 'M') {
            System.out.println("I Am Man");
        } else {
            System.out.println("I Am Woman");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 140) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        if (sex == 'M') {
            this.sex = 'M';
        } else {
            this.sex = 'F';
        }
    }

    public boolean equals(Person person) {
        if (this.name.equals(person.name) && this.age == person.age && this.sex == person.sex) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return name + "," + age + "," + sex;

    }
}
 class PersonTest{
     public static void main(String[] args) {
         Person p1, p2;
         p1 = new Person(10, "张三", 'M');
         p2 = new Person();
         p2.setName("陈红");
         p2.setAge(30);
         p2.setSex('F');
         p1.introduce();
         p2.introduce();
     }
}
