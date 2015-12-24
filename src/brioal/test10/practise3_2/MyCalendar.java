package brioal.test10.practise3_2;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MyCalendar {
    public static void main(String args[]) {
        new CalendarWindow();
    }
}

class CalendarWindow extends JFrame implements ChangeListener {
    JSpinner jsp = null;
    CalPane calPane = null;
    Container con = null;
    CalendarBean cal = null;

    CalendarWindow() {
        SpinnerModel model =
                new SpinnerNumberModel(2009, 1990, 2090, 1);
        jsp = new JSpinner(model);
        jsp.addChangeListener(this);
        jsp.setEditor(new JSpinner.NumberEditor(jsp, "#"));
        con = this.getContentPane();
        con.add(jsp, BorderLayout.NORTH);
        CalendarBean cal = new CalendarBean();
        calPane = new CalPane(cal.getYear(), cal);
        con.add(calPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);
        setSize(400, 240);
        setVisible(true);
        validate();
    }

    public void stateChanged(ChangeEvent e) {
        con.remove(calPane);
        int year = (Integer) jsp.getValue();
        calPane = new CalPane(year, cal);
        con.add(calPane, BorderLayout.CENTER);
        con.validate();
        validate();
    }
}

class CalPane extends JPanel implements ActionListener {
    JTable table;
    String a[][] = new String[6][7];
    String colName[] = {"��", "һ", "��", "��", "��", "��", "��"};
    JButton nextMonth, previousMonth;
    int year, month;
    CalendarBean calendar;
    JLabel showMessage = new JLabel("", JLabel.CENTER);

    public CalPane(int y, CalendarBean cal) {
        setLayout(new BorderLayout());
        year = y;
        calendar = cal;
        cal.setYear(year);
        cal.setMonth(month);
        String day[] = cal.getCalendar();
        table = new JTable(a, colName);
        table.setRowSelectionAllowed(false);
        setTable(day);
        nextMonth = new JButton("����");
        previousMonth = new JButton("����");
        nextMonth.addActionListener(this);
        previousMonth.addActionListener(this);
        JPanel pNorth = new JPanel(),
                pSouth = new JPanel();
        pNorth.add(previousMonth);
        pNorth.add(nextMonth);
        pSouth.add(showMessage);
        showMessage.setText("������" + calendar.getYear() + "��" + calendar.getMonth() + "��");
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(pNorth, BorderLayout.NORTH);
        add(pSouth, BorderLayout.SOUTH);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextMonth) {
            month = month + 1;
            if (month > 12)
                month = 1;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            setTable(day);
            table.repaint();
        } else if (e.getSource() == previousMonth) {
            month = month - 1;
            if (month < 1)
                month = 12;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            setTable(day);
            table.repaint();
        }
        showMessage.setText("������" + calendar.getYear() + "��" + calendar.getMonth() + "��");
    }

    public void setTable(String day[]) {                      //���ñ��Ԫ���е����ݡ�
        int n = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                a[i][j] = day[n];
                n++;
            }
        }
    }
}

class CalendarBean {
    String day[];
    Calendar rili;

    public CalendarBean() {
        rili = Calendar.getInstance();
        rili.set(getYear(), getMonth() - 1, 1);
    }

    public void setYear(int year) {
        rili.set(Calendar.YEAR, year);
        ;
    }

    public int getYear() {
        return rili.get(Calendar.YEAR);
    }

    public void setMonth(int month) {
        rili.set(Calendar.MONTH, month - 1);
    }

    public int getMonth() {
        return rili.get(Calendar.MONTH - 1);
    }

    public String[] getCalendar() {
        String a[] = new String[42];
        int year = getYear();
        int month = getMonth();
        int week = rili.get(Calendar.DAY_OF_WEEK) - 1;
        int day = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = 30;
        }
        if (month == 2) {
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                day = 29;
            } else {
                day = 28;
            }
        }
        for (int i = week, n = 1; i < week + day; i++) {
            a[i] = String.valueOf(n);
            n++;
        }
        return a;
    }
}
