package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.*;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {

        return medianPublicationYear(transformBookSetToMap(bookSet));
    }

    protected Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> transformBookSetToMap (Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> bookSignatureBookMap = new HashMap<>();

        for(Book book : bookSet) {
            BookSignature newBookSignature = new BookSignature(book.getSignature());
            com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book newBook = new com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book(
                    book.getAuthor(),
                    book.getTitle(),
                    book.getPublicationYear());

            bookSignatureBookMap.put(newBookSignature, newBook);
        }

        return bookSignatureBookMap;
    }
}
