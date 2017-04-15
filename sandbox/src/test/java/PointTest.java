import by.mmjava.sandbox.Point;
import org.testng.annotations.Test;
import org.testng.Assert;
/**
 * Created by User on 4/15/2017.
 */
public class PointTest{
    @Test
    public void Pointtest() {
        Point p1 = new Point(100,2);
        Point p2 = new Point(4,33);
        Assert.assertEquals(p1.distance(p2),100.88111815399351);
        Point p3 = new Point(12,35);
        Point p4 = new Point(55,66);
        Assert.assertEquals(p3.distance(p4),53.009433122794285);
        Point p5 = new Point(-11,-66);
        Point p6 = new Point(0,55);
        Assert.assertEquals(p5.distance(p6),121.49897118905987);
            }
}
