package com.kodilla.exception.main;

import com.kodilla.exception.io.*;

import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main(String[] args) { //throws IOException {
        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        } catch (FileReaderException  e) {
            System.out.println(e);
        }
    }
}
