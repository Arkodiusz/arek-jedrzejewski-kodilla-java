package com.kodilla.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpsRunnerTestSuite {

    @Test
    void testCompareRockPaper() {
        //given
        Game game = new Game();
        game.p1.setFigure(1);
        game.p2.setFigure(2);
        //when
        //then
        assertEquals(2, game.compare()); // paper wins
    }

    @Test
    void testCompareRockScissors() {
        //given
        Game game = new Game();
        game.p1.setFigure(1);
        game.p2.setFigure(3);
        //when
        //then
        assertEquals(1, game.compare()); // rock wins
    }

    @Test
    void testComparePaperRock() {
        //given
        Game game = new Game();
        game.p1.setFigure(2);
        game.p2.setFigure(1);
        //when
        //then
        assertEquals(1, game.compare()); // paper wins
    }

    @Test
    void testComparePaperScissors() {
        //given
        Game game = new Game();
        game.p1.setFigure(2);
        game.p2.setFigure(3);
        //when
        //then
        assertEquals(2, game.compare()); // scissors wins
    }
    @Test
    void testCompareScissorsRock() {
        //given
        Game game = new Game();
        game.p1.setFigure(3);
        game.p2.setFigure(1);
        //when
        //then
        assertEquals(2, game.compare()); // rock wins
    }
    @Test
    void testCompareScissorsPaper() {
        //given
        Game game = new Game();
        game.p1.setFigure(3);
        game.p2.setFigure(2);
        //when
        //then
        assertEquals(1, game.compare()); // scissors wins
    }
}
