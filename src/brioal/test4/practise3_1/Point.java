package brioal.test4.practise3_1;

import java.awt.*;

/**
 * Created by brioal on 15-9-13.
 */
public class Point {
    private int x;
    private int y;
    private Color mycolor;

    //无参构造
    public Point() {

    }

    //带参构造
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //带参构造
    public Point(int x, int y, Color mycolor) {
        this.x = x;
        this.y = y;
        this.mycolor = mycolor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getMycolor() {
        return mycolor;
    }

    public void setMycolor(Color mycolor) {
        this.mycolor = mycolor;
    }

    //    获取距离
    public double distance(Point p) {
        return Math.sqrt(Math.abs(this.x - p.x)
                        * Math.abs(this.x - p.x)
                        +
                        Math.abs(this.y - p.y)
                                * Math.abs(this.y - p.y)
        );
    }

    @Override
    public String toString() {
        return x + ":" + y+"color:"+mycolor;
    }


    public boolean equals(Point p) {
        return this.x == p.getX() && this.y == p.getY()&&this.mycolor==p.getMycolor();
    }

    public static void main(String[] args) {
        Point a = new Point();
        Point b = new Point(50, 60);
        Point c = new Point(100, 200, Color.black);

        System.out.println();
        a.setX(100);
        a.setY(200);
        a.setMycolor(Color.black);
        b.setMycolor(Color.black);
        System.out.println("B:(" + b.getX() + "," + b.getY() + ")" + "color:" + b.getMycolor());

        System.out.println("A==B?" + a.equals(b));
        System.out.println();
        System.out.println("A-->B=" + a.distance(b));
    }
}
