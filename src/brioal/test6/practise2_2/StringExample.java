package brioal.test6.practise2_2;

/**
 * Created by brioal on 15-10-6.
 */

public class StringExample {
    public static void main(String[] args) {
        String s1 = new String("you are a student"),
                s2 = new String("how are you");
        if (s1.equals(s2)) {
            System.out.println("s1��s2��ͬ");
        } else {
            System.out.println("s1��s2����ͬ");
        }
        String s3 = new String("��"),
                s4 = new String("��");
        if (s3.compareTo(s4) > 0) {
            System.out.println("s3���ֵ������s4");
        } else {
            System.out.println("s3���ֵ���С��s4");
        }

        int position = 0 ;
        String path = "d:\\shiyan\\src\\shiyan3\\People.java";
        position = path.lastIndexOf("\\"); // ������ָ���ַ�������
        System.out.println("Path������\\λ����" + position);
        String filename = path.split("\\\\")[4]; // �����ַ���ָ���Ҫ����\\
        System.out.println("path�������ļ���" + filename);
        String s6 = new String("100"),
                s7 = new String("123.678");
        int n1 = Integer.parseInt(s6);
        double n2 = Double.parseDouble(s7);
        double n = n1+n2;
        System.out.println(n);
        String s8 = new String("ABCDEF");
        char a[] = s8.toCharArray();
        for (int i = a.length-1; i >=0; i--) {//�������
            System.out.printf("%3c", a[i]);

        }
    }

}
