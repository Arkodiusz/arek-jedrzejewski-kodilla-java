package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("names.txt").getFile());

        //Path path = Paths.get(file.getPath());
        //Path path = Paths.get("xd.txt");
        //System.out.println("PATH: " + path);
        //Stream<String> fileLines = Files.lines(Paths.get("names.txt"));

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
        //try (Stream<String> fileLines = Files.lines(Paths.get("c:\\java\\kodilla-course\\kodilla-exception\\src\\main\\resources\\names.txt"))) {
                        fileLines.forEach(l -> System.out.println(l));
            } catch (IOException e) {
                System.out.println("Błąd odczytu pliku " + e);
            }
            finally {
                System.out.println("I am gonna be here... always!");
            }
        }

}
