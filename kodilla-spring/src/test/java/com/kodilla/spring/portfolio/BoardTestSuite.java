package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void boardNotNullTest() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        //Then
        assertNotNull(board.getToDoList());
        assertNotNull(board.getInProgressList());
        assertNotNull(board.getDoneList());
    }

    @Test
    void testTaskAdd() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        board.getToDoList().add("zad1");
        board.getInProgressList().add("zad2");
        board.getDoneList().add("zad3");

        assertAll(
                () -> assertEquals("zad1 ", board.getToDoList().readTasks()),
                () -> assertEquals("zad2 ", board.getInProgressList().readTasks()),
                () -> assertEquals("zad3 ", board.getDoneList().readTasks())
        );
    }
}
