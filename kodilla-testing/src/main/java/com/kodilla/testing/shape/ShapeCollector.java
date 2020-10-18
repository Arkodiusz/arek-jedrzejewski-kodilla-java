//6.4
package com.kodilla.testing.shape;

import java.util.List;
import java.util.ArrayList;


public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    public String showFigures() {
        String string = "";

        for(Shape shape : shapes) {
            string+=shape.getShapeName() + "; ";
        }

        return string;

    }

}
