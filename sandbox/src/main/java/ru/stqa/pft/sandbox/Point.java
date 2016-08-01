package ru.stqa.pft.sandbox;

import java.lang.reflect.Array;

import static java.lang.Math.pow;


/**
 * Created by goga on 18.07.2016.
 */
public class Point {
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void distance(Point p1, Point p2){
        int xcoord = (p2.getX() - p1.getX())*(p2.getX() - p1.getX());
        int ycoord = (p2.getY() - p1.getY())*(p2.getY() - p1.getY());
        double distance =  Math.sqrt(xcoord + ycoord);
        System.out.println(distance);
    }

}
