package brioal.test6.practise1_4;

/**
 * Created by brioal on 15-10-6.
 */

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("ABCDEFG");
        System.out.println("原内容 " + buffer);
//        内容拼接
        buffer.append("123456789");
        System.out.print("内容拼接  ");
        System.out.println(buffer);
//        设置内容
        buffer.setCharAt(1, 'b');
        System.out.print("更改指定下标的内容 ");
        System.out.println(buffer);
//        插入内容
        buffer.insert(6, "Love");
        System.out.print("指定下标插入内容  ");
        System.out.println(buffer);
        //获取指定字符的下标
        int index = buffer.indexOf("1");
//        剧下标范围删除指定内容
        buffer.delete(index, index + 4);
        System.out.print("指定下标范围删除内容    ");
        System.out.println(buffer);
//        获取字符串长度
        int n = buffer.length();
//        据下标范围替换指定内容
        buffer.replace(n - 3, n, "七八九");
        System.out.print("指定下标范围替换内容  ");
        System.out.println(buffer);

        StringBuffer otherbuffer = new StringBuffer("we love you");
        System.out.println("原字符串    "+otherbuffer);
        int start = 0 ;
        char c = '\0';
        while (start != -1) {
            if (start != 0) {
                start++;
            }
//            第一个字符赋值给c
            c = otherbuffer.charAt(start);
            //如果是小写
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);//变换为大写
                otherbuffer.setCharAt(start, c);//将c处的下标赋值给start
            }
            //indexof(String str , int index)
            //返回从指定下标开始第一次出现指定字符串的下标,
            //此处相当于获得下一个首字母的下标
            start = otherbuffer.indexOf(" ", start);
        }
        System.out.print("首字母变大写后的字符串   ");
        System.out.println(otherbuffer);
        StringBuffer yourbuffer = new StringBuffer("i Love This GaME");
        System.out.println("原字符串    "+yourbuffer);
        for (int i = 0; i < yourbuffer.length(); i++) {
            char c1 = yourbuffer.charAt(i);//当前下标的字符
            if (Character.isLowerCase(c1)) {//如果是小写则变为大写
                c1 = Character.toUpperCase(c1);
                yourbuffer.setCharAt(i, c1);  //替换指定下标的内容
            }else if (Character.isUpperCase(c1)) { //如果是大写则变为小写
                c1 = Character.toLowerCase(c1);
                yourbuffer.setCharAt(i, c1); //替换指定下标的内容
            }
        }
        System.out.print("大小写交换后的字符串   ");
        System.out.println(yourbuffer);
    }

}
