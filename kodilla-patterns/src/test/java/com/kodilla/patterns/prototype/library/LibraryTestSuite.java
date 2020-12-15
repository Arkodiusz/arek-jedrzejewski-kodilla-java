package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {

        //Given
        //default object
        Library library1 = new Library("Library 1");

        library1.getBooks().add(new Book("Dziady I", "Mickiewicz A.", LocalDate.of(1822, 1, 20)));
        library1.getBooks().add(new Book("Hobbit", "Tolkien J. R. R", LocalDate.of(1937, 9, 21)));
        library1.getBooks().add(new Book("Maly Ksiaze", "Saint-Exupery A.", LocalDate.of(1943, 4, 6)));

        //shallow copied object
        Library clonedLibrary = null;
        try {
            clonedLibrary = library1.shallowCopy();
            clonedLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //deep copied object
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library1.deepCopy();
            deepClonedLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library1.getBooks().stream().findFirst().get().setTitle("abcdefg");

        //Then
        System.out.println(library1);
        System.out.println("\n" + clonedLibrary);
        System.out.println("\n" + deepClonedLibrary);

        assertEquals(library1.getBooks().size(), 3);
        assertEquals(library1.getBooks(), clonedLibrary.getBooks());
        assertNotEquals(library1.getBooks(), deepClonedLibrary.getBooks());
    }
}
