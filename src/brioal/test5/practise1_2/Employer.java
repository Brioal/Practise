package brioal.test5.practise1_2;

/**
 * Created by brioal on 15-9-13.
 */
abstract class Employer {
    String EmpName; //名字
    char sex; //性别
    double Empsal; //工资
//    带参构造
    public Employer(String empName, char sex, double Empsal) {
        EmpName = empName;
        this.sex = sex;
        this.Empsal = Empsal;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getEmpsal() {
        return Empsal;
    }

    public void setEmpsal(double empsal) {
        this.Empsal = empsal;
    }

    public abstract double getSal();

    public void setSal(int basSal) {
        Empsal = basSal;
    }
}
//工人类
class Worker extends Employer {
    char category; //种类
    boolean dressAllowance; // 服装津贴
//    带参构造
    public Worker(String empName, char sex, double Empsal,char category , boolean dressallowance) {
        super(empName, sex, Empsal);
        this.category = category;
        this.dressAllowance =dressallowance;
    }

    public char getCategory() {
        return category;
    }

    public boolean isDressAllowance() {
        return dressAllowance;
    }
//    方法重写
    @Override
    public double getSal() {
        return Empsal;
    }
}

/*****************************************/
//上司类
class Superior extends Employer {
    int experoence; //经验
    boolean vehicle; //是否有车
    double mediaAllowance; // 媒体津贴
//    带参构造
    public Superior(String empName, char sex, double Empsal,int e , boolean v , double ma) {
        super(empName, sex, Empsal);
        this.experoence = e ;
        this.vehicle = v;
        this.mediaAllowance = ma;
    }

    public int getExperoence() {
        return experoence;
    }

    public boolean isVehicle() {
        return vehicle;
    }

    public double getMediaAllowance() {
        return mediaAllowance;
    }
    //方法重写
    @Override
    public double getSal() {
        return 0;
    }
}
//官员类
class Officer extends Superior {
    double traveAllowance; //旅行津贴
//    带参构造
    public Officer(String empName, char sex, double Empsal, int e, boolean v, double ma,double ta) {
        super(empName, sex, Empsal, e, v, ma);
        this.traveAllowance = ta;
    }

    public double getTraveAllowance() {
        return traveAllowance;
    }
//    方法重写
    @Override
    public double getSal() {
        return Empsal * 2 + 200 + traveAllowance + mediaAllowance;
    }
}

/*********************************************/
//经理类
class Manager extends Superior {
    double clubAllowance;  //社团津贴
//    带参构造
    public Manager(String empName, char sex, double Empsal, int e, boolean v, double ma,double cs) {
        super(empName, sex, Empsal, e, v, ma);
        this.clubAllowance = cs;
    }

    public double getClubAllowance() {
        return clubAllowance;
    }
//    方法重写
    @Override
    public double getSal() {
        return Empsal * 5 + 2000 + mediaAllowance + clubAllowance;
    }
}

/*********************************************/
//测试类
class InheDemo {
    public static void main(String[] args) {
        Worker w = new Worker("M.John", 'M', 1200.50, 'B', true);//创建工人类
//        输出工人信息
        System.out.println("工人信息: ");
        System.out.printf("姓名:"+w.getEmpName());
        System.out.printf("性别:"+w.getSex());
        System.out.printf("薪资:"+w.getSal());
        System.out.printf("类别:" + w.getCategory());
        if (w.isDressAllowance()) {
            System.out.println("提供服装津贴");
        } else {
            System.out.println("未提供服装津贴");
        }
//        创建上司类并输出上司信息
        Officer o = new Officer("S.David", 'F', 2500.70, 15, true, 245.60, 200);
        System.out.println();
        System.out.println("主任信息:");
        System.out.printf("姓名:"+o.getEmpName());
        System.out.printf("性别:" + o.getSex());
        System.out.printf("薪资:" + o.getSal());
        System.out.printf("工作经验:" + o.getExperoence() + "年");
        if (o.isVehicle()) {
            System.out.println("提供交通工具");
        } else {
            System.out.println("未提供交通工具");
        }
        System.out.println("医疗津贴:" + o.getMediaAllowance());
        System.out.println("出差津贴:" + o.getTraveAllowance());
//        创建经理类并输出信息
        Manager m = new Manager("ArnoldShwaz", 'M', 4500.70, 15, true, 245.60, 300);
        System.out.println();
        System.out.println("经理信息:");
        System.out.printf("姓名:" + m.getEmpName());
        System.out.printf("性别:" + m.getSex());
        System.out.printf("薪资:" + m.getSal());
        System.out.println("工作经验:" + m.getExperoence() + "年");
        if (m.isVehicle()) {
            System.out.println("提供交通工具");
        } else {
            System.out.println("未提供交通工具");
        }
        System.out.println("医疗津贴:" + m.getMediaAllowance());
        System.out.println("会员津贴:" + m.getClubAllowance());
    }
}
