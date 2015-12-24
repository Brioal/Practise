package brioal.test4.practise3_2;

public class Martrix {
    int row;//存储行
    int col;//存储列
    int[][] data;//存储数组

    //    空构造
    public Martrix() {
    }

    //    带参构造 ,传入数组
    public Martrix(int data[][]) {
        this.data = data;
        this.row = data.length;
        this.col = data[0].length;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public boolean equals(Martrix martrix) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (this.data[i][j] != martrix.getData()[i][j]) {
//                    存在某一个元素不同则直接返回false
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                str += data[i][j];
                str += "  ";
            }
            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        Martrix mar1 = new Martrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Martrix mar2 = new Martrix();
        Martrix mar3 = new Martrix(new int[][]{{0, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Martrix mar4 = new Martrix();

        mar2.setData(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        mar4.setData(mar3.getData());
        System.out.println(mar1);
        System.out.println(mar2);
        System.out.println(mar3);
        System.out.println(mar4);
        System.out.println("mar2==mar3? " + mar2.equals(mar3));//false


    }
}
