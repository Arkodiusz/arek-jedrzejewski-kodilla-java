package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("\nLIST # elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
            .filter(book -> book.getYearOfPublication() > 2005)
            .collect(Collectors.toMap(Book::getSignature, book -> book));

       System.out.println("\nMAP # elements: " + theResultMapOfBooks.size());
       theResultMapOfBooks.entrySet().stream()
          .map(entry -> entry.getKey() + ": " + entry.getValue())
            .forEach(System.out::println);

        //BookDirectory theBookDirectory = new BookDirectory();
        System.out.println("\n");
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);


    }



}