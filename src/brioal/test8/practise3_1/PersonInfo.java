package brioal.test8.practise3_1;

import brioal.test6.practise1_4.StringBufferExample;

import java.io.*;

/**
 * Created by Null on 2015/10/29.
 */
public class PersonInfo {
    private String school;
    private String name;
    private String id;
    private String tel;
    private String phone;
    private String mail;

    public PersonInfo() {
    }

    public PersonInfo(String school, String name, String id, String tel, String phone, String mail) {
        this.school = school;
        this.name = name;
        this.id = id;
        this.tel = tel;
        this.phone = phone;
        this.mail = mail;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSchool() {
        return school;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public void Save() {

        File file = new File("data/" + name + ".txt");
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(fileWriter);) {
            writer.write("************************************************************");
            writer.newLine();
            writer.write(school + "\t\t\t" + name + "\t\t\t" + id + "\n");
            writer.write("电话:" + tel + "\t\t\t" + "手机:" + phone + "\n");
            writer.write("邮箱:" + mail + "\n");
            writer.write("************************************************************");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public String toString() {
        String str = null;
        StringBuilder builder = new StringBuilder();
        try (FileReader fileReader = new FileReader("data/" + name + ".txt");
             BufferedReader reader = new BufferedReader(fileReader)){

            while ((str = reader.readLine()) != null) {
                builder.append(str+"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
