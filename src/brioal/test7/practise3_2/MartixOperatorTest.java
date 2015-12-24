package brioal.test7.practise3_2;

import java.io.File;
import java.util.Scanner;

/**
 * Created by brioal on 15-10-14.
 */

public class MartixOperatorTest {
    public static void main(String[] args) {
//        ͨ����ȡ�����������Martrix����
        Martrix first = MartrixOperator.Read("data/first_.txt");
        Martrix second = MartrixOperator.Read("data/second.txt");
//        ���Martrix����
        System.out.println("��һ������:\n" + first);
        System.out.println("�ڶ�������:\n" + second);
//        ����ѡ��
        System.out.println("��ѡ��Ҫ���е�����:");
        System.out.println("======================================");
        System.out.println("================1. �ӷ�===============");
        System.out.println("================2. ����===============");
        System.out.println("================3. �˷�===============");
        System.out.println("================4. ����===============");
//        ���������������
        Scanner keyin = new Scanner(System.in);
        int select = keyin.nextInt();
        switch (select) {
            case 1:
                try { // ����,���мӷ����������������ֵҪ��Ӧ���
                    if ((first.getRow() == second.getRow()) && (first.getCol() == second.getCol())) {
                        System.out.println("�ӷ������:\n" + MartrixOperator.add(first, second));
                        SaveAndRead(MartrixOperator.add(first, second), "data/add.txt");
                    } else {
                        throw new RowColException("���мӼ����������������,����ֵ�����Ӧ���");
                    }
                } catch (RowColException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try { // ����,���м������������������ֵҪ��Ӧ���
                    if ((first.getRow() == second.getRow()) && (first.getCol() == second.getCol())) {
                        System.out.println("���������:\n" + MartrixOperator.sub(first, second));
                        SaveAndRead(MartrixOperator.sub(first, second), "data/sub.txt");


                    } else {
                        throw new RowColException("���мӼ����������������,����ֵ�����Ӧ���");
                    }
                } catch (RowColException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try { // ����,���г˷�����������,��һ�������к͵ڶ������������
                    if ((first.getRow() == second.getRow()) && (first.getCol() == second.getCol())) {
                        System.out.println("�˷������:\n" + MartrixOperator.mul(first, second));
                        SaveAndRead(MartrixOperator.mul(first, second), "data/mul.txt");
                    } else {
                        throw new RowColException("���мӼ����������������,����ֵ�����Ӧ���");
                    }
                } catch (RowColException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                try { // ����,���д���������������������������ȵķ���
                    if ((first.getRow()==first.getCol())&&(second.getRow()==second.getCol())&&(first.getRow()==second.getRow())) {
                        System.out.println("���������:\n" + MartrixOperator.div(first, second));
                        SaveAndRead(MartrixOperator.div(first, second), "data/div.txt");
                    } else {
                        throw new RowColException("���мӼ����������������,����ֵ�����Ӧ���");
                    }
                } catch (RowColException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("�������!,�������");
                System.exit(0);
        }
    }

    //�������ݵ����ز��Ҷ�ȡ��ʾ
    public static void SaveAndRead(Martrix martrix, String filename) {
        System.out.print("���������浽"+filename);
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MartrixOperator.Save(martrix, filename);
        System.out.println();
        if (new File(filename).exists()) {
            System.out.print("��⵽������:"+filename+"��ȡ��");
            for (int i = 0; i < 5; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("��ȡ���Ľ��Ϊ:\n" + MartrixOperator.Read(filename));
        }
    }
}
