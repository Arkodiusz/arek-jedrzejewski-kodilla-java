package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify (String ugly, PoemDecorator poemDecorator) {
        String beautiful = poemDecorator.decorate(ugly);
        System.out.println(beautiful);
    }


}
