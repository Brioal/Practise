package brioal.test7.practise3_2;

import java.io.*;

/**
 * Created by brioal on 15-10-14.
 */

public class MartrixOperator {
    public static void main(String[] args) {
        Martrix martrix = MartrixOperator.Read("first.txt");
    }

    //    ��ȡ����
    public static Martrix Read(String fileName) {
        Martrix result = new Martrix();
        try (FileReader reader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String[] ss = br.readLine().split("\\s+");
//            System.out.println(ss[0]);
//            System.out.println(ss[1]);
            int Row = Integer.valueOf(ss[0]);
            int Col = Integer.valueOf(ss[1]);
            String[] sss = null;
            int[][] data = new int[Row][Col];
            for (int i = 0; i < Row; i++) {
                sss = br.readLine().split("\\s+");
                for (int j = 0; j < Col; j++) {
                    data[i][j] = Integer.valueOf(sss[j]);
                }
            }

            result.setData(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    //    д������
    public static void Save(Martrix result, String filename) {
        File file = new File(filename);

        try (FileWriter os = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(os)) {

            int[][] data = result.getData();
            writer.write(result.getRow() + "\t" + result.getCol());
            writer.newLine();
            for (int i = 0; i < data.length; i++) {
                String str = "";
                for (int j = 0; j < data[0].length; j++) {
                    str += data[i][j] + "\t";
                }
                writer.write(str);
                writer.newLine();
            }
//    writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //    �ӷ�
    public static Martrix add(Martrix first, Martrix second) {
        System.out.println("ִ�мӷ�");
        Martrix result = null;
        int[][] data = new int[first.getRow()][first.getCol()];
        for (int i = 0; i < first.getRow(); i++) {
            for (int j = 0; j < first.getCol(); j++) {
                data[i][j] = first.getData()[i][j] + second.getData()[i][j];
            }
            result = new Martrix(data);
        }
        return result;
    }

    //    ����
    public static Martrix sub(Martrix first, Martrix second) {
        System.out.println("ִ�м���");
        Martrix result = null;
        int[][] data = new int[first.getRow()][first.getCol()];
        for (int i = 0; i < first.getRow(); i++) {
            for (int j = 0; j < first.getCol(); j++) {
                data[i][j] = first.getData()[i][j] - second.getData()[i][j];
            }
            result = new Martrix(data);
        }
        return result;
    }

    //    �˷�
    public static Martrix mul(Martrix first, Martrix second) {
        int[][] data = new int[first.getRow()][second.getCol()];
        for (int i = 0; i < first.getRow(); i++) {
            for (int j = 0; j < second.getCol(); j++) {
                int sum = 0;
                for (int k = 0; k < first.getCol(); k++) {
                    sum += first.getData()[i][k] * second.getData()[k][j];
                }
                data[i][j] = sum;
            }
        }
        return new Martrix(data);
    }

    //    ����
//    �����������Ҫ������ֵȫ�����
    public static Martrix div(Martrix first, Martrix second) {

        second = getinverseMartrix(second);
//        System.out.println(second);

        return mul(first, second);
    }

    //    ��ȡ����������
    public static Martrix getinverseMartrix(Martrix martrix) {
        int[][] data = martrix.getData();//ԭ����
        int[][] tempdata = new int[martrix.getRow()][martrix.getCol() * 2]; //�¾���
//        ��Ӧ���ָ�ֵ
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                tempdata[i][j] = data[i][j];
            }
        }
//        ȱ�ٲ�����䵥λ����
        for (int i = 0; i < tempdata.length; i++) {
            for (int j = data.length; j < tempdata[0].length; j++) {
                if (i == j - data.length) {
                    tempdata[i][j] = 1;
                } else {
                    tempdata[i][j] = 0;
                }
            }
        }


        int tempRow = tempdata.length;
        int tempCol = tempdata[0].length;
        // �Խ���������Ϊ0ʱ�����ڽ������к�
        int line = 0;
        // �Խ��������ֵĴ�С
        int bs = 0;
        // һ����ʱ���������ڽ�������ʱ���м�����
        int swap = 0;
        for (int i = 0; i < tempRow; i++) {
            // ����߲��ֶԽ����ϵ����ݵ���0���������н��н���
            if (tempdata[i][i] == 0) {
                if (++line >= tempRow) {
                    System.out.println("�˾���û�������");
                    return null;
                }

                for (int j = 0; j < tempCol; j++) {
                    swap = tempdata[i][j];
                    tempdata[i][j] = tempdata[line][j];
                    tempdata[line][j] = swap;
                }

                // ��ǰ�У���i�У����line�н��н�������Ҫ���¶Ե�i�н��д���
                // ��ˣ���Ҫ���б�i��1����Ϊ��forѭ���лὫi��1��
                i--;
                // ������i�д�����ʱ��i�е�������ԭ����line�е����ݡ�
                continue;
            }

            // ����߲��־���Խ����ϵ����ݱ��1.0
            if (tempdata[i][i] != 1) {
                bs = tempdata[i][i];
                for (int j = tempCol - 1; j >= 0; j--) {
                    tempdata[i][j] /= bs;
                }
                // ����߲��־������϶ԽǾ���
                // ��ν�϶ԽǾ����Ǿ�������½�Ԫ��ȫΪ0
                for (int iNow = i + 1; iNow < tempRow; iNow++) {
                    for (int j = tempCol - 1; j >= i; j--) {
                        tempdata[iNow][j] -= tempdata[i][j] * tempdata[iNow][i];
                    }
                }
            }
        }

        // ����߲��־�����϶ԽǾ����ɵ�λ���󣬼�����������Ͻ�Ԫ��Ҳ��Ϊ0
        for (int i = 0; i < tempRow - 1; i++) {
            for (int iNow = i; iNow < tempRow - 1; iNow++) {
                for (int j = tempCol - 1; j >= 0; j--) {
                    tempdata[i][j] -= tempdata[i][iNow + 1]
                            * tempdata[iNow + 1][j];
                }
            }
        }

        // �ұ߲��־������������

        int cRow = tempRow;
        int cColumn = tempCol / 2;
        int[][] newdata = new int[cRow][cColumn];
        // ���ұ߲��ֵ�ֵ����cData
        for (int i = 0; i < cRow; i++) {
            for (int j = 0; j < cColumn; j++) {
                newdata[i][j] = tempdata[i][cColumn + j];
            }
        }
        // �õ�����󣬷���
        return new Martrix(newdata);

    }
}
