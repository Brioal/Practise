package brioal.test7.practise3_2;

public class Martrix {
    int row;//�洢��
    int col;//�洢��
    int[][] data;//�洢����

    //    �չ���
    public Martrix() {
    }

    //    ���ι��� ,��������
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
//                    ����ĳһ��Ԫ�ز�ͬ��ֱ�ӷ���false
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
