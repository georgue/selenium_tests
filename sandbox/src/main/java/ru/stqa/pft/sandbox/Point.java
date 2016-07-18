package ru.stqa.pft.sandbox;

import java.lang.reflect.Array;

/**
 * Created by goga on 18.07.2016.
 */
public class Point {
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;

    }
    public void distance(Point p1, Point p2){
        this.x = p1.x - p2.x;
        this.y = p2.y - p2.y;
        System.out.println(x + " " + y);
    }

}
