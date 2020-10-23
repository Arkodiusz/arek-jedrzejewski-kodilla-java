package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

import static java.lang.String.valueOf;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String text = "kodilla java bootcamp";

        poemBeautifier.beautify(text, (ugly) -> text.toUpperCase());

        poemBeautifier.beautify(text, (ugly) -> {
            String string = text.replace('a', '@');
            string = string.replace('o', '0');
            return string;
        });

        poemBeautifier.beautify(text, (ugly) -> {
            char[] textArray = text.toCharArray();
            String string = "\n";
            for(int i = 0; i < textArray.length; i++) {
                string += textArray[i] + "\n";
            }
            return string;
        });

        poemBeautifier.beautify(text, (ugly) -> {
            char[] textArray = text.toCharArray();
            String string = "";
            int toReplace = 0;

            String c = valueOf(textArray[0]);
            c=c.toUpperCase();
            textArray[0]=c.charAt(0);

            for (int i = 0; i < textArray.length; i++) {
                if (textArray[i] == ' ') {
                    textArray[i + 1] = textArray[i+1];
                    c = valueOf(textArray[i+1]);
                    c = c.toUpperCase();
                    textArray[i+1]=c.charAt(0);
                }
            }

            for (int i = 0; i < textArray.length; i++) {
                if (textArray[i] != ' ') {
                    string+=textArray[i];
                }
            }

            return string;
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