package brioal.test5.practise3_1;

/**
 * Created by brioal on 15-10-6.
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
        System.out.println("My Name Is " + name + "/nMy Age Is " + age);
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
