package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
//import com.kodilla.stream.lambda.ExpressionExecutor;
//import com.kodilla.stream.reference.FunctionalCalculator;

import static java.lang.String.valueOf;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String text1 = "lockdown";
        String text2 = "kodilla";
        String text3 = "vertical";
        String text4 = "conversion to camel case";

        poemBeautifier.beautify(text1, String::toUpperCase);

        poemBeautifier.beautify(text2, (ugly) -> {
            String string = ugly.replace('a', '@');
            string = string.replace('o', '0');
            return "\n" + string;
        });

        poemBeautifier.beautify(text3, (ugly) -> {
            char[] textArray = ugly.toCharArray();
            StringBuilder string = new StringBuilder("\n");
            for (char c : textArray) {
                string.append(c).append("\n");
            }
            return string.toString();
        });

        poemBeautifier.beautify(text4, (ugly) -> {
            char[] textArray = ugly.toCharArray();
            StringBuilder string = new StringBuilder();

            for (int i = 0; i < textArray.length; i++) {
                if (textArray[i] == ' ') {
                    textArray[i + 1] = textArray[i+1];
                    String c = valueOf(textArray[i+1]);
                    c = c.toUpperCase();
                    textArray[i+1]=c.charAt(0);
                }
            }

            for (char value : textArray) {
                if (value != ' ') {
                    string.append(value);
                }
            }

            return string.toString();
        });

//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//
//        System.out.println("Calculating expressions with lambdas");
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
//
//        System.out.println("Calculating expressions with method references");
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
    }
}