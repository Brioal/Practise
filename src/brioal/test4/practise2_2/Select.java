package brioal.test4.practise2_2;

/**
 * Created by brioal on 15-9-13.
 */

public class Select {
    public static void main(String[] args) {
        int n = 100;
        Sieve sieve = new Sieve();
        sieve.executeFilter(n);
        System.out.println("小于" + n + "的素数有:");
        sieve.outFilter();
    }


}

class Count {
    private int value;

    Count(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void next() {
        value++;
    }
}


class Sieve {
    final int Max = 100;
    private int filterCount = 0;
    private int[] f;

    public Sieve() {
        f = new int[Max];
        filterCount = 0;
    }

    public void executeFilter(int n) {
        Count c = new Count(2);
        for (; c.getValue() < n; c.next()) {
            System.err.print(c.getValue() + "-进入元素过滤");
            passFilter(c);
        }
    }

    public void passFilter(Count count) {
        for (int i = 0; i < filterCount / 2; i++) {
            if (count.getValue() % f[i] == 0) {
                //合数的筛选方法:能被素数整除的一定是合数
                System.err.println(+count.getValue() + "-是合数,直接跳出passFilter方法");
                return;
            }
        }
        System.err.println(count.getValue() + "-是素数,添加到数组");
        addElementary(count.getValue());
    }

    //添加元素,添加int类型于f数组的后面
    public void addElementary(int x) {
        f[filterCount] = x; //此时f[fitercount]作为原数组的下一个元素是没有值的
        filterCount++;
    }

    //输出数组所有元素
    public void outFilter() {
        for (int i = 0; i < filterCount; i++) {
            System.out.printf("%4d", f[i]);//%4d 为控制元素格式的写法.意思是每个元素占4个字符,不够的空格补全
            if ((i + 1) % 10 == 0) {
                System.out.println();//满十个元素就换行
            }

        }
    }
}
