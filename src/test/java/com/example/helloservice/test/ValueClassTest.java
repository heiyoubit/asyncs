package com.example.helloservice.test;

public class ValueClassTest {
    private final Point p;

    public ValueClassTest(Point p) {
        this.p = p;
    }

    public void printP() {
        System.out.println(p);
    }

    public static void main(String[] args) {
        new ValueClassTest(new Point(1, 2)).printP();
    }
}


record Point(int x, int y) { }