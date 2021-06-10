package by.mmjava.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by User on 4/15/2017.
 */
public class SquareTests {
    @Test     //аннотация
    public void testArea() {
Square s = new Square(5);
Assert.assertEquals(s.area(),25.0);
    }
}
