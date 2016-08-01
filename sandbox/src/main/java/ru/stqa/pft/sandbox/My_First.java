package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

public class My_First {

    @Test
    public void test1() {

        Point p1 = new Point(1, 1);
        Point p2 = new Point(9, 5);
        p1.distance(p1, p2);
    }

    @Test
    public  void test2(){
        Point p1 = new Point(2, 2);
        Point p2 = new Point(4, 4);
        p1.distance(p1, p2);
    }

    @Test
    public  void test3(){
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 2);
        p1.distance(p1, p2);
    }


}




