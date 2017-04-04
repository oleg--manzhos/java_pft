package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        Point a = new Point(3.0, 6.0);
        Point b = new Point(-2.0, 3.0);


//        p1.cordX = 3;
//        p1.cordY = 6;
//
//        p2.cordX = -2;
//        p2.cordY = 3;

        //calculation using method (Zadanie 2.2)
        //System.out.println("Distance between two points using distance (p1, p2) method equals to " + distance(p1, p2));

        //calculation using function (Zadanie 2.3)
        //dist = Math.sqrt(Math.pow(p2.cordX - p1.cordX, 2) + Math.pow(p2.cordY - p1.cordY, 2));
        //System.out.println("Distance between two points equals to " + dist);

        /*Calculation according to comments from Igor Lyubin:

        Class Point should describe one point.
        Like that:

        Point a = new Point(3.0, 6.0);
        Point b = new Point(-2.0, 3.0);
        */

        System.out.println("Distance between a and b points calculated using method from Point class equals to " + Point.dist(a, b));
    }

//    public static double distance(Point p1, Point p2) {
//        double dist = 0;
//        dist = Math.sqrt(Math.pow(p2.cordX - p1.cordX, 2) + Math.pow(p2.cordY - p1.cordY, 2));
//
//        return dist;
//    }
}
