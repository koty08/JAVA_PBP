package com.bdobe;

public class Rectangle extends Shape {
    int width;
    int height;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public float getLength() {
        return (float)width + height;
    }

    @Override
    public float getArea() {
        return (float)width * height;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Rectangle, Area: %.2f, Length: %.2f", getArea(), getLength()));
    }
}