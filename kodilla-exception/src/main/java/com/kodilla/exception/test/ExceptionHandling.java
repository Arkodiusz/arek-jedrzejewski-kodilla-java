package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void handle(double x, double y) throws Exception {

        SecondChallenge secondChallenge = new SecondChallenge();
        String status = "";

        try {
            status = secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            status = "Parameters out of bounds!" + e;
            throw e;
        } finally {
            System.out.println(status);
        }
    }
}
