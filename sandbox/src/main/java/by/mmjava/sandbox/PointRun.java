package by.mmjava.sandbox;

/**
 * Created by User on 4/12/2017.
 */
public class PointRun {
    public static void main(String[] args) {
        //Point p1 = new Point(100, 2);
        //Point p2 = new Point(4, 33);
        Point p3 = new Point(100,2,4,33);
           System.out.println("Path between [" + p3.x + ";"+ p3.y + "] and [" +p3.x1+";"+p3.y1 + "] is = " + p3.distancemethod());
    }
    /*public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x-p2.x), 2) + Math.pow((p1.y-p2.y), 2));
    }*/

}