package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        AtomicReference<String> s = new AtomicReference<>("Library [" + name + "]");
        books.forEach( book -> s.set(s.get() + "\n" + book));
        return s.get();
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book : books) {
             clonedLibrary.getBooks().add(book.clone());
        }
        return clonedLibrary;
    }

    public void setName(String s) {
        this.name = s;
    }
}
