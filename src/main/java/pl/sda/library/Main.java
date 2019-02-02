package pl.sda.library;

import pl.sda.library.model.Book;
import pl.sda.library.model.BookBuilder;
import pl.sda.library.model.Library;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new BookBuilder()
                .authorFirstName("Carol")
                .authorLastName("Lewis")
                .title("Lew, czarownica i stara szafa")
                .build())
        ;

        library.addBook(new BookBuilder().authorFirstName("John").authorLastName("Tolkien")
                .title("Harry Potter i kamien filozoficzny").build());

        library.addBook(new BookBuilder().authorFirstName("John").authorLastName("Tolkien")
                .title("Wladca pierscieni").build());

        library.addBook(new BookBuilder().authorFirstName("John").authorLastName("Tolkien")
                .title("Hobbit").build());

        for (Book book : library.getBooks()){
            System.out.println(book);
        }
    }
}
