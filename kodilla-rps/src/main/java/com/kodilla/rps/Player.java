package com.kodilla.rps;

public class Player {

    private String name;
    private int figure;
    private int score;

    public Player(String name) {
        this.name = name;
        this.figure = 0;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getFigure() {
        return figure;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFigure (int figure) {
        this.figure = figure;
    }

    public void resetScore() { this.score = 0; }

    public void addScore() {
        this.score += 1;
    }

}

