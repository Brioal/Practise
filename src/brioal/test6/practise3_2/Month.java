package brioal.test6.practise3_2;

import java.util.Calendar;

/**
 * Created by brioal on 15-10-15.
 */

public class Month {
    private Calendar calendar;
    private String data[][] = new String[5][7];
    private int year , month ;

    public Month(int year, int month) {
        this.year = year;
        this.month = month;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        int day = 1;
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 当前月的总天数
        // 设置从1号开始
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int day_of_weak = calendar.get(Calendar.DAY_OF_WEEK);//获取1号是星期几

        int row = 0;
        while (day < days) {
            data[row][day_of_weak - 1] = String.valueOf(day);
            day++;
            day_of_weak++;
            if (day_of_weak == 8) {
                day_of_weak = 1;
                row++;

            }
        }
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("                      " + year + "年" + month + "月              \n");
        sb.append("============================================================\n");

        sb.append("  星期日  星期一  星期二  星期三  星期四  星期五  星期六\n");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                sb.append("\t");
                if (data[i][j] == null) {
                    sb.append("");
                } else {
                sb.append(data[i][j]);
                }
                sb.append("\t");
            }
            sb.append("\n");
        }
        sb.append("**************************************************************");
        return sb.toString();
    }
}
