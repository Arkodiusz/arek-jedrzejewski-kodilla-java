package com.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASKLIST")
public class TaskList {

    private int id;
    private String listName;
    private String decription;

    public TaskList() {
    }

    public TaskList(String listName, String decription) {
        this.listName = listName;
        this.decription = decription;
    }

    public TaskList(String listName) {
        this.listName = listName;
        this.decription = decription;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique=true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDecription() {
        return decription;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setDecription(String decription) {
        this.decription = decription;
    }
}
