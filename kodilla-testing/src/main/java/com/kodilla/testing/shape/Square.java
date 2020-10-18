//6.4
package com.kodilla.testing.shape;

public class Square implements Shape{

    private String ShapeName;
    private double sideA;
    private double field;

    public Square(double sideA) {
        this.ShapeName="SQUARE";
        this.sideA=sideA;
        this.field=calculateField();
    }

    public String getShapeName() {
        return ShapeName;
    }

    public double getField() {
        return this.field;
    }

    private double calculateField() {
        return Math.pow(sideA, 2);
    }
}
