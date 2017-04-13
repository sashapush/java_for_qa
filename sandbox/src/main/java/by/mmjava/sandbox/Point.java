package by.mmjava.sandbox;

/**
 * Created by User on 4/11/2017.
 */
public class Point {
    public double x;
    public double y;
    public double x1;
    public double y1;

    public Point(double x, double y,double x1,double y1) {
        this.x = x;
        this.y = y;
        this.y1 = y1;
        this.x1 = x1;
    }
    public  double distancemethod() {
        return Math.sqrt(Math.pow((this.x-this.x1), 2) + Math.pow((this.y-this.y1), 2));
    }

}
