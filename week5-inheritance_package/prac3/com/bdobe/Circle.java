package com.bdobe;

public class Circle extends Shape {
    int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public float getLength() {
        return (float) (2 * radius * Math.PI);
    }

    @Override
    public float getArea() {
        return (float) (radius * radius * Math.PI);
    }

    @Override
    public void draw() {
        System.out.println(String.format("Circle, Area: %.2f, Length: %.2f", getArea(), getLength()));
    }
}
