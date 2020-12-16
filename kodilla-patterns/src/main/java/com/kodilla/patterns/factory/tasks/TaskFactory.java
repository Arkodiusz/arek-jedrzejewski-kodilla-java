package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING  = "DRIVING";

    public final Task makeTask(final String TaskClass) {
        switch (TaskClass) {
            case SHOPPING:
                return new ShoppingTask("Buy avocados", "Avocado", 21);
            case PAINTING:
                return new PaintingTask("Paint your grass green", "green", "grass");
            case DRIVING:
                return new DrivingTask("Drive home ", "home", "uber");
            default:
                return null;
        }
    }
}
