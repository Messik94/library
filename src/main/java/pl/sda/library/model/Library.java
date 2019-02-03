package pl.sda.library.model;

import java.util.*;

public class Library<T extends Book> {

    private List<T> books;

    public List<T> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void setBooks(List<T> books) {
        this.books = new LinkedList<>(books);
    }

    public void addBook(T book){
        if (books == null){
            books = new LinkedList<>();
        }
        books.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
