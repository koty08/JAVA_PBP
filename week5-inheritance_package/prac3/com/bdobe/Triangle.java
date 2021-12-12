package com.bdobe;

public class Triangle extends Shape {
    int a, b, c;

    public Triangle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float getLength() {
        return (float)a+b+c;
    }

    @Override
    public float getArea() {
        double s = (a+b+c)/2.0;
        double res = s * (s-a) * (s-b) * (s-c);

        return (float) Math.sqrt(res);
    }

    @Override
    public void draw() {
        System.out.println(String.format("Triangle, Area: %.2f, Length: %.2f", getArea(), getLength()));
    }
}
