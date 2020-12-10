package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public Board board() {
        return new Board(toDo(), inProgress(), done());
    }

    @Bean
    public TaskList toDo() {
        return new TaskList();
    }

    @Bean
    public TaskList inProgress() {
        return new TaskList();
    }

    @Bean
    public TaskList done() {
        return new TaskList();
        //return null;
    }
}
