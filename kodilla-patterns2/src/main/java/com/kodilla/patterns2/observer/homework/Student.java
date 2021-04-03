package com.kodilla.patterns2.observer.homework;

import lombok.Getter;

@Getter
public class Student {

    private String name;

    private TaskList toDoTaskList;
    private TaskList inVerificationTaskList;
    private TaskList doneTaskList;

    public Student(String name) {
        this.name = name;
        toDoTaskList = new TaskList();
        inVerificationTaskList = new TaskList();
        doneTaskList = new TaskList();
    }

    public void sendTaskToReview(Long id) {
        inVerificationTaskList.addTask(toDoTaskList.retrieveTask(id));
    }
}
