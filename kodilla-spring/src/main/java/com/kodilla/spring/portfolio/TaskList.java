package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        tasks.add(task);
    }

    public String readTasks() {
        String string = "";
        for(String s : tasks) {
            string += s + " ";
        }
        return string;
    }
}
