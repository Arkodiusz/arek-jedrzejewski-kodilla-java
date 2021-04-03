package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void testUpdate() {
        // Given
        Task task1 = new Task(1L, "Task 1");
        Task task2 = new Task(2L, "Task 2");
        Task task3 = new Task(3L, "Task 3");
        Task task4 = new Task(4L, "Task 4");
        Task task5 = new Task(5L, "Task 5");

        Student student1 = new Student("Student 1");
        Student student2 = new Student("Student 2");
        Student student3 = new Student("Student 3");

        student1.getToDoTaskList().addTask(task1);
        student1.getToDoTaskList().addTask(task2);
        student1.getToDoTaskList().addTask(task3);

        student2.getToDoTaskList().addTask(task2);
        student2.getToDoTaskList().addTask(task4);
        student2.getToDoTaskList().addTask(task5);

        student3.getToDoTaskList().addTask(task1);
        student3.getToDoTaskList().addTask(task3);
        student3.getToDoTaskList().addTask(task5);

        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");

        student1.getInVerificationTaskList().registerObserver(mentor1);
        student2.getInVerificationTaskList().registerObserver(mentor1);

        student3.getInVerificationTaskList().registerObserver(mentor2);

        // When
        student1.sendTaskToReview(1L);
        student1.sendTaskToReview(2L);
        student1.sendTaskToReview(3L);

        student2.sendTaskToReview(2L);
        student2.sendTaskToReview(4L);
        student2.sendTaskToReview(5L);

        student3.sendTaskToReview(1L);
        student3.sendTaskToReview(3L);
        student3.sendTaskToReview(5L);

        // Then
        assertEquals(6, mentor1.getPendingTasks());
        assertEquals(3, mentor2.getPendingTasks());
    }
}
