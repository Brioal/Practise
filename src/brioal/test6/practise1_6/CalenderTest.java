package brioal.test6.practise1_6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by brioal on 15-10-6.
 */

public class CalenderTest {
    public static void main(String[] args) {
//        获取当前日历对象
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String year = String.valueOf(calendar.get(Calendar.YEAR)),
                month = String.valueOf(calendar.get(Calendar.MONTH)),
                day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),
                weekday = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)-1);
        int hour = calendar.get(Calendar.HOUR),
                minute = calendar.get(Calendar.MINUTE),
                seconde = calendar.get(Calendar.SECOND);
        System.out.println("现在的时间是:");
        System.out.println(year + "年" + month + "月" + day + "日" + "星期" + weekday);
        System.out.println(hour + "时" + minute + "分" + seconde + "秒");
        calendar.set(2008, 3, 8);//设置时间
        long time2008 = calendar.getTimeInMillis(); // 获取毫秒偏移值
        calendar.set(2009, 3, 8);
        long time2009 = calendar.getTimeInMillis();
        long days = (time2009 - time2008) / (1000 * 60 * 60 * 60 * 24);
        System.out.println("2009年3月8日和2008年3月8日相隔" + days + "天");
        Date date = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("EEEE-MMMM-dd-yyyy");
        System.out.println(format1.format(date));
        DateFormat format2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        System.out.println(format2.format(date));

    }

}
