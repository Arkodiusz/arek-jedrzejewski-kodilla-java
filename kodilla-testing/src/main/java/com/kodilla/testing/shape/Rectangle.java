package com.kodilla.testing.shape;

public class Rectangle implements Shape{

    private String ShapeName;
    private double sideA;
    private double sideB;
    private double field;

    public Rectangle(double sideA, double sideB) {
        this.ShapeName="RECTANGLE";
        this.sideA=sideA;
        this.sideB=sideB;
        this.field=calculateField();
    }

    public String getShapeName() {
        return ShapeName;
    }

    public double getField() {
        return this.field;
    }

    private double calculateField() {
        return sideA * sideB;
    }
}
