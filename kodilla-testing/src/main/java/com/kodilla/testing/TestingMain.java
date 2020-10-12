package com.kodilla.testing;

//        import com.kodilla.testing.user.SimpleUser;
        import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        Calculator calculator = new Calculator();

        if (calculator.add(a, b) == a + b) {
            System.out.println("Add - test OK");
        } else {
            System.out.println("Add - Error!");
        }

        if (calculator.sub(a, b) == a - b) {
            System.out.println("Sub - test OK");
        } else {
            System.out.println("Sub - Error!");
        }
    }
}


//        SimpleUser simpleUser = new SimpleUser("theForumUser");
//
//        String result = simpleUser.getUsername();
//
//        if (result.equals("theForumUser")){
//            System.out.println("Simple user - test OK");
//        } else {
//            System.out.println("Simple user - Error!");
//        }