package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public Player p1 = new Player("");
    public Player p2 = new Player("");
    private Scanner sc = new Scanner (System.in);
    private Random rand = new Random();

    private char figure = ' ';
    private int intFigure = 0;
    private boolean end = false;

    private int goal = 0;

    public int compare() {

        int f1 = p1.getFigure();
        int f2 = p2.getFigure();

        // return 0 - round draw
        // return 1 - player 1
        // return 2 - player 2

        if (f1==f2) return 0;
        if (f1==1) {
            if (f2 == 2) return 2;
            if (f2 == 3) return 1;
        }
        if (f1==2) {
            if (f2 == 1) return 1;
            if (f2 == 3) return 2;
        }
        if (f1==3) {
            if (f2 == 1) return 2;
            if (f2 == 2) return 1;
        }
        return 0;
    }

    public void newGame() {

        System.out.println("Witaj w grze papier, kamień, nożyce");

        System.out.println("Podaj swoje imię:");
        p1.setName(sc.next());
        System.out.println("Utworzono gracza " + p1.getName());

        p2.setName("Komputer");
        System.out.println("Utworzono gracza " + p2.getName());

        System.out.println("Ile punktów daje zwycięstwo");
        this.goal = sc.nextInt();
        System.out.println("Liczba punktów do zwycięstwa: " + goal);

        System.out.println("\nINSTRUKCJA\n" +
                "klawisz 1 – zagranie \"kamień\",\n" +
                "klawisz 2 – zagranie \"papier\",\n" +
                "klawisz 3 – zagranie \"nożyce\",\n" +
                "klawisz x – zakończenie gry\n" +
                "klawisz n – uruchomienie gry od nowa" );

        gameplay();
    }

    public void gameplay() {

        while(!end) {
            if (p1.getScore()<goal && p2.getScore()<goal) {

                System.out.println("\n" + p1.getName() + " " + p1.getScore() + " : " + p2.getScore() + " " + p2.getName());
                System.out.println("\nWybierz symbol: ");
                do {
                    figure = sc.next().charAt(0);
                    if (figure == '1' || figure == '2' || figure == '3') {

                        if (figure == '1') intFigure = 1;
                        if (figure == '2') intFigure = 2;
                        if (figure == '3') intFigure = 3;

                        p1.setFigure(intFigure);
                        showChosenFigure(p1);

                        p2.setFigure(rand.nextInt(2)+1);
                        showChosenFigure(p2);

                        revealRoundWinner(compare());

                    } else {
                        if (figure == 'x') {
                            confirmExit();
                        }
                        if (figure == 'n') {
                            confirmReset();
                        }
                    }
                } while (chosenFigureIsNotCorrect());

            } else {
                revealGameWinner();
            }
        }
    }

    public void revealRoundWinner(int roundWinner) {
        if (roundWinner == 1) {
            p1.addScore();
            System.out.println("Rundę wygrywa " + p1.getName());
        }
        else if (roundWinner == 2){
            p2.addScore();
            System.out.println("Rundę wygrywa " + p2.getName());
        }
        else {
            System.out.println("Runda remisowa");
        }
    }

    public void revealGameWinner() {
        System.out.println("\n" + p1.getName() + " " + p1.getScore() + " : " + p2.getScore() + " " + p2.getName());
        System.out.print("Wygrał ");
        if(p1.getScore()==goal) System.out.println(p1.getName());
        if(p2.getScore()==goal)System.out.println(p2.getName());
        end = true;
    }

    public boolean chosenFigureIsNotCorrect() {
        return figure!= '1' && figure!= '2' && figure!= '3' && figure!= 'x' && figure!= 'n';
    }

    public void showChosenFigure(Player p) {
        System.out.print("" + p.getName() + " wybrał ");
        if (p.getFigure()==1) System.out.print("kamień");
        if (p.getFigure()==2) System.out.print("papier");
        if (p.getFigure()==3) System.out.print("nożyce");
        System.out.println();
    }

    public void confirmExit() {
        System.out.println("Czy na pewno zakończyć grę? t/n");
        char answer = sc.next().charAt(0);
        if (answer=='t') end = true;
        //else gameplay();
    }

    public void confirmReset() {
        System.out.println("Czy na pewno rozpocząć od nowa? t/n");
        char answer = sc.next().charAt(0);
        if (answer == 't') {
            resetGame();
        }
        //else gameplay();
    }

    public void resetGame() {
        p1.setFigure(0);
        p2.setFigure(0);
        p1.resetScore();
        p2.resetScore();
        gameplay();
    }
}
