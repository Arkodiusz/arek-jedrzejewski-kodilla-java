//6.4
package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;

public class ShapeCollectorTestSuite {
    static int counter = 1;

    @BeforeEach
    public void before() {
        System.out.println("Test Case " + counter + ": begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case " + counter + ": end");
        counter++;
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("ShapeCollector Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("ShapeCollector Test Suite: end");
    }

    @DisplayName("check behavior when adding element")
    @Test
    void testAddFigure() {
        //Given
        Shape circle = new Circle(5);
        Shape square = new Square(6);
        Shape rectangle = new Rectangle(7, 7);

        ShapeCollector collector = new ShapeCollector();

        collector.addFigure(circle);
        collector.addFigure(square);
        collector.addFigure(rectangle);

        //When
        List<Shape> testShapes = new ArrayList<>();
        testShapes.add(circle);
        testShapes.add(square);
        testShapes.add(rectangle);

        //Then
        Assertions.assertEquals(testShapes, collector.getShapes());
    }

    @DisplayName("check behavior when removing element")
    @Test
    void testRemoveFigure() {
        //Given
        Shape circle = new Circle(5);
        Shape square = new Square(6);
        Shape rectangle = new Rectangle(7, 7);

        ShapeCollector collector = new ShapeCollector();

        collector.addFigure(circle);
        collector.addFigure(square);
        collector.addFigure(rectangle);
        collector.removeFigure(circle);

        //When
        List<Shape> testShapes = new ArrayList<>();
        testShapes.add(circle);
        testShapes.add(square);
        testShapes.add(rectangle);
        testShapes.remove(circle);

        //Then
        Assertions.assertEquals(testShapes, collector.getShapes());
    }

    @DisplayName("check behavior when getting specified element")
    @Test
    void testGetFigure() {
        //Given
        Shape circle = new Circle(5);
        Shape square = new Square(6);
        Shape rectangle = new Rectangle(7, 7);

        ShapeCollector collector = new ShapeCollector();

        collector.addFigure(circle);
        collector.addFigure(square);
        collector.addFigure(rectangle);

        Shape actual = collector.getFigure(2);

        //When
        List<Shape> testShapes = new ArrayList<>();
        testShapes.add(circle);
        testShapes.add(square);
        testShapes.add(rectangle);

        Shape expected = testShapes.get(2);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("check behavior when printing all elements")
    @Test
    void testShowFigures() {
        //Given
        Shape circle = new Circle(5);
        Shape square = new Square(6);
        Shape rectangle = new Rectangle(7, 7);

        ShapeCollector collector = new ShapeCollector();

        collector.addFigure(circle);
        collector.addFigure(square);
        collector.addFigure(rectangle);

        String actual = collector.showFigures();

        //When
        List<Shape> testShapes = new ArrayList<>();
        testShapes.add(circle);
        testShapes.add(square);
        testShapes.add(rectangle);

        String expected = "";

        for(Shape testShape : testShapes) {
            expected+=testShape.getShapeName() + "; ";
        }

        //Then
        Assertions.assertEquals(expected, actual);
    }
}