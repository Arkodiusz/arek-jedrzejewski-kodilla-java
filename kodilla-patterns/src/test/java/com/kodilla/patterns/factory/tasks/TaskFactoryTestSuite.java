package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task task = factory.makeTask("SHOPPING");
        System.out.println(task.getTaskName());

        //Then
        assertEquals(task.isTaskExecuted(), false);
        assertEquals(task.executeTask(), "Bought 21 pcs. of Avocado");
        assertEquals(task.isTaskExecuted(), true);
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task task = factory.makeTask("PAINTING");
        System.out.println(task.getTaskName());

        //Then
        assertEquals(task.isTaskExecuted(), false);
        assertEquals(task.executeTask(), "Painted grass on green");
        assertEquals(task.isTaskExecuted(), true);
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task task = factory.makeTask("DRIVING");
        System.out.println(task.getTaskName());

        //Then
        assertEquals(task.isTaskExecuted(), false);
        assertEquals(task.executeTask(), "Went to home with uber");
        assertEquals(task.isTaskExecuted(), true);
    }

}
