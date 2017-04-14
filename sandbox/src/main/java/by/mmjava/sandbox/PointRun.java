package by.mmjava.sandbox;

/**
 * Created by User on 4/12/2017.
 */
public class PointRun {
    public static void main(String[] args) {
        Point p1 = new Point(100, 2);
        Point p2 = new Point(4, 33);
        System.out.println("(By method) Path between [" + p1.x + ";"+ p1.y + "] and [" +p2.x+";"+p2.y + "] is = " + p1.distance(p2));


        System.out.println("(By function) Path between [" + p1.x + ";"+ p1.y + "] and [" +p2.x+";"+p2.y + "] is = " + distance(p1,p2));

    }
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x-p2.x), 2) + Math.pow((p1.y-p2.y), 2));

    }

}