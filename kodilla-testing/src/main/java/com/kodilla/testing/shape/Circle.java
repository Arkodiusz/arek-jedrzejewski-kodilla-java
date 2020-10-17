package com.kodilla.testing.shape;

public class Circle implements Shape{

    private String ShapeName;
    private double radius;
    private double field;

    public Circle(double radius) {
      this.ShapeName="CIRCLE";
      this.radius=radius;
      this.field=calculateField();
    }

    public String getShapeName() {
        return ShapeName;
    }

    public double getField() {
        return this.field;
    }

    private double calculateField() {
        double pi = Math.PI;
        return Math.pow((pi * radius), 2);
    }
}
