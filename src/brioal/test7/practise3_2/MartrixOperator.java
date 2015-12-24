package brioal.test7.practise3_2;

import java.io.*;

/**
 * Created by brioal on 15-10-14.
 */

public class MartrixOperator {
    public static void main(String[] args) {
        Martrix martrix = MartrixOperator.Read("first.txt");
    }

    //    读取数据
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


    //    写入数据
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

    //    加法
    public static Martrix add(Martrix first, Martrix second) {
        System.out.println("执行加法");
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

    //    减法
    public static Martrix sub(Martrix first, Martrix second) {
        System.out.println("执行减法");
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

    //    乘法
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

    //    除法
//    矩阵除法必须要求行列值全部相等
    public static Martrix div(Martrix first, Martrix second) {

        second = getinverseMartrix(second);
//        System.out.println(second);

        return mul(first, second);
    }

    //    获取矩阵的逆矩阵
    public static Martrix getinverseMartrix(Martrix martrix) {
        int[][] data = martrix.getData();//原矩阵
        int[][] tempdata = new int[martrix.getRow()][martrix.getCol() * 2]; //新矩阵
//        对应部分赋值
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                tempdata[i][j] = data[i][j];
            }
        }
//        缺少部分填充单位矩阵
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
        // 对角线上数字为0时，用于交换的行号
        int line = 0;
        // 对角线上数字的大小
        int bs = 0;
        // 一个临时变量，用于交换数字时做中间结果用
        int swap = 0;
        for (int i = 0; i < tempRow; i++) {
            // 将左边部分对角线上的数据等于0，与其他行进行交换
            if (tempdata[i][i] == 0) {
                if (++line >= tempRow) {
                    System.out.println("此矩阵没有逆矩阵！");
                    return null;
                }

                for (int j = 0; j < tempCol; j++) {
                    swap = tempdata[i][j];
                    tempdata[i][j] = tempdata[line][j];
                    tempdata[line][j] = swap;
                }

                // 当前行（第i行）与第line行进行交换后，需要重新对第i行进行处理
                // 因此，需要将行标i减1，因为在for循环中会将i加1。
                i--;
                // 继续第i行处理，此时第i行的数据是原来第line行的数据。
                continue;
            }

            // 将左边部分矩阵对角线上的数据变成1.0
            if (tempdata[i][i] != 1) {
                bs = tempdata[i][i];
                for (int j = tempCol - 1; j >= 0; j--) {
                    tempdata[i][j] /= bs;
                }
                // 将左边部分矩阵变成上对角矩阵，
                // 所谓上对角矩阵是矩阵的左下角元素全为0
                for (int iNow = i + 1; iNow < tempRow; iNow++) {
                    for (int j = tempCol - 1; j >= i; j--) {
                        tempdata[iNow][j] -= tempdata[i][j] * tempdata[iNow][i];
                    }
                }
            }
        }

        // 将左边部分矩阵从上对角矩阵变成单位矩阵，即将矩阵的右上角元素也变为0
        for (int i = 0; i < tempRow - 1; i++) {
            for (int iNow = i; iNow < tempRow - 1; iNow++) {
                for (int j = tempCol - 1; j >= 0; j--) {
                    tempdata[i][j] -= tempdata[i][iNow + 1]
                            * tempdata[iNow + 1][j];
                }
            }
        }

        // 右边部分就是它的逆矩阵

        int cRow = tempRow;
        int cColumn = tempCol / 2;
        int[][] newdata = new int[cRow][cColumn];
        // 将右边部分的值赋给cData
        for (int i = 0; i < cRow; i++) {
            for (int j = 0; j < cColumn; j++) {
                newdata[i][j] = tempdata[i][cColumn + j];
            }
        }
        // 得到逆矩阵，返回
        return new Martrix(newdata);

    }
}
