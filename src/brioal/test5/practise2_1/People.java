package brioal.test5.practise2_1;

/**
 * Created by brioal on 15-9-21.
 * 方法的重写
 */

/*****************父类People***********/
class People {
    protected double weight, height;//身高体重属性

    public void speakHello() {
        System.out.println("Who am I?");
    }

    public void averageHeight() {
        height = 173;
        System.out.println("Average Height:" + height);
    }

    public void averageWight() {
        weight = 70;
        System.out.println("Average Wight:" + weight);
    }
}

//子类ChinaPeople
class ChinaPeople extends People {
    @Override
    public void speakHello() {
        System.out.println("哈喽,我是中国人!");
    }

    @Override
    public void averageHeight() {
        height = 168.78;
        System.out.println("Average Height:" + height);
    }

    @Override
    public void averageWight() {
        weight = 65;
        System.out.println("Average Wight:" + weight);
    }
//    子类特有的方法
    public void chinaGongfu() {
        System.out.println("坐如钟,站如松,睡如弓");
    }
}

//子类AmeracaPeople
class AmericaPeople extends People {
    @Override
    public void speakHello() {
        System.out.println("Hello , I am America!");
    }

    @Override
    public void averageHeight() {
        height = 170;
        System.out.println("Average Height:" + height);
    }

    @Override
    public void averageWight() {
        weight = 70;
        System.out.println("Average Wight:" + weight);
    }
//    子类特有的方法
    public void americanBoxing() {
        System.out.println("The staright,hook");
    }
}

//ChinaPeople的子类
class BeijingPeople extends ChinaPeople {
    @Override
    public void speakHello() {
        System.out.println("您好,俺是北京人");
    }
    //子类特有方法
    public void beijingOpera() {
        System.out.println("京剧");
    }

    @Override
    public void averageHeight() {
        super.averageHeight();
    }

    @Override
    public void averageWight() {
        super.averageWight();
    }

    @Override
    public void chinaGongfu() {
        super.chinaGongfu();
    }
}

//测试类
class PeopleTest {
    public static void main(String[] args) {
//        对象创建
        ChinaPeople chinaPeople = new ChinaPeople();
        AmericaPeople americaPeople = new AmericaPeople();
        BeijingPeople beijingPeople = new BeijingPeople();
//        各对象speakHello方法
        chinaPeople.speakHello();
        americaPeople.speakHello();
        beijingPeople.speakHello();
//        各对象averageHeight方法
        chinaPeople.averageHeight();
        americaPeople.averageHeight();
        beijingPeople.averageHeight();
//        各对象averageWight方法
        chinaPeople.averageWight();
        americaPeople.averageWight();
        beijingPeople.averageWight();
//        各对象特有方法
        chinaPeople.chinaGongfu();
        americaPeople.americanBoxing();
        beijingPeople.beijingOpera();
        beijingPeople.chinaGongfu();
    }
}

