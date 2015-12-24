package brioal.test7.practise3_2;

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

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
        this.row = data.length;
        this.col = data[0].length;
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
                str += "\t";
            }
            str += "\n";
        }

        return str;
    }


}
