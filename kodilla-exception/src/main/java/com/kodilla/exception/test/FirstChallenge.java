package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        double result = 0;

        try {
            result = firstChallenge.divide(3, 0);
        } catch (ArithmeticException e) {
            result = 0.0;
            System.out.println("Exception: " + e + " -> result = 0.0;" );
        } finally {
            System.out.println(result);
        }
    }
}