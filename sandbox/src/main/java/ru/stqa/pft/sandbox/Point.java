package ru.stqa.pft.sandbox;

/**
 * Created by omanzhos on 3/31/2017.
 */
public class Point {

    double cordX = 0;
    double cordY = 0;

    Point(double cordX, double cordY) {

        this.cordX = cordX;
        this.cordY = cordY;
    }


    public static double dist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.cordX - p1.cordX, 2) + Math.pow(p2.cordY - p1.cordY, 2));
    }

//    public double dist() {
//        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//    }
}
