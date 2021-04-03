package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTest {

    @Test
    void transformBookSetToMapTest() {
        //Given
        Set<Book> bookSet = new HashSet<>(Arrays.asList(
                new Book("a1", "t1", 2000, "s1"),
                new Book("a2", "t2", 2001, "s2")
        ));

        //When
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> bookSignatureBookMap = new MedianAdapter().transformBookSetToMap(bookSet);

        //Then
        assertEquals(bookSignatureBookMap.size(), bookSet.size());
    }


    @Test
    void publicationYearMedianTest() {
        // Given
        Set<Book> bookSet = new HashSet<>(Arrays.asList(
                new Book("a1", "t1", 2000, "s1"),
                new Book("a2", "t2", 2001, "s2"),
                new Book("a3", "t3", 2004, "s3"),
                new Book("a4", "t4", 2005, "s4"),
                new Book("a5", "t5", 2006, "s5"),
                new Book("a6", "t6", 2008, "s6"),
                new Book("a7", "t7", 2011, "s7"),
                new Book("a8", "t8", 2015, "s8")
        ));

        // When
        int publicationYearMedian = new MedianAdapter().publicationYearMedian(bookSet);

        // Then
        System.out.println(publicationYearMedian);
        //exactly 2005,5
        assertEquals(2006, publicationYearMedian);
    }

}