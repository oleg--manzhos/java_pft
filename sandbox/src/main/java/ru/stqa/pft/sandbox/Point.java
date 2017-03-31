package ru.stqa.pft.sandbox;

/**
 * Created by omanzhos on 3/31/2017.
 */
public class Point {

    double cordX = 0;
    double cordY = 0;
    double x1, x2, y1, y2;

    Point() {
    }

    Point(double cordX1, double cordY1, double cordX2, double cordY2) {

        x1 = cordX1;
        x2 = cordX2;
        y1 = cordY1;
        y2 = cordY2;
    }

    public static double dist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.cordX - p1.cordX, 2) + Math.pow(p2.cordY - p1.cordY, 2));
    }

    public double dist() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
