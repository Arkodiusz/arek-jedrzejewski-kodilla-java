package com.kodilla.patterns2.observer.homework;

import lombok.Getter;

import java.util.List;

@Getter
public class Mentor implements Observer {

    private String name;
    private int pendingTasks;

    public Mentor(String name) {
        this.name = name;
        pendingTasks = 0;
    }

    @Override
    public void update(TaskList taskList) {
        List<Task> list = taskList.getTasks();
        System.out.println(name + ": New task to review: " + list.get(list.size()-1).getTitle());
        pendingTasks++;
    }
}
