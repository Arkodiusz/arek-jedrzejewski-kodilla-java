package com.kodilla.spring.shape;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ShapesFactory {

    @Bean
    public Square createSquare() {
        return new Square();
    }

    @Bean
    public Shape chosenShape() {
        Random rand = new Random();
        int chosen = rand.nextInt(3);
        if (chosen == 0) return new Triangle();
        else if (chosen == 1) return new Circle();
        else return new Square();
    }
}
