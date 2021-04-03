package com.kodilla.patterns2.observer.homework;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TaskList implements Observable {

    private List<Task> tasks = new ArrayList<>();

    private final List<Observer> observers = new ArrayList<>();

    public boolean addTask(Task task) {
        if (!tasks.contains(task)) {
            tasks.add(task);
            notifyObservers();
            return true;
        }
        return false;
    }

    public Task retrieveTask(Long id) {
        Long processedTaskId = null;
        Long i = 0L;
        for(Task task : tasks) {
            if (task.getTaskId().equals(id)) {
                processedTaskId = i;
            }
            i++;
        }
        if(processedTaskId != null) {
            return tasks.remove(Math.toIntExact(processedTaskId));
        }
        throw new RuntimeException();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
