package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by omanzhos on 3/31/2017.
 */
public class PointTests {

  @Test
  public void someLength(){
      Assert.assertEquals(Point.dist(new Point(3, 6), new Point(-2.0, 3.0)), 5.830951894845301, "Distance is incorrect");
  }

   @Test
   public void zeroLength(){
       Assert.assertEquals(Point.dist(new Point(0, 0), new Point(0, 0)), 0.0, "Distance is incorrect");
   }

    @Test
    public void positiveLength(){
        Assert.assertEquals(Point.dist(new Point(2, 3), new Point(1, 7)), 4.123105625617661, "Distance is incorrect");
    }

    @Test
    public void negativeCoordinates(){
        Assert.assertEquals(Point.dist(new Point(-2, -3), new Point(-5, -3)), 3.0, "Distance is incorrect");
    }
}