package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point(3.0, 6.0, -2.0, 3.0);

        p1.cordX = 3;
        p1.cordY = 6;

        p2.cordX = -2;
        p2.cordY = 3;

        double dist = 0;

        //calculation using method (Zadanie 2.2)
        System.out.println("Distance between two points using distance (p1, p2) method equals to " + distance(p1, p2));

        //calculation using function (Zadanie 2.3)
        dist = Math.sqrt(Math.pow(p2.cordX - p1.cordX, 2) + Math.pow(p2.cordY - p1.cordY, 2));
        System.out.println("Distance between two points equals to " + dist);

        //calculation using method of Point class (Zadanie 2.4)
        System.out.println("Distance between two points calculated using method from Point class equals to " + Point.dist(p1, p2));

        //calculation using method of overloaded constructor from the Point class
        System.out.println("Distance between two points calculated using parameters of overloaded constructor is equal to " + p3.dist());
    }

    public static double distance(Point p1, Point p2) {
        double dist = 0;
        dist = Math.sqrt(Math.pow(p2.cordX - p1.cordX, 2) + Math.pow(p2.cordY - p1.cordY, 2));

        return dist;
    }
}
