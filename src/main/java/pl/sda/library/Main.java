package pl.sda.library;

import pl.sda.library.model.*;

public class Main {

    public static void main(String[] args) {
        Library<Book> library = new Library<>(); // drugie <> nie trzeba Book
        library.addBook(new BookPaperBuilder()
                .authorFirstName("Carol")
                .authorLastName("Lewis")
                .title("Lew, czarownica i stara szafa")
                .cover(Cover.HARD)
                .build())
        ;

        library.addBook(new BookPaperBuilder().authorFirstName("John").authorLastName("Tolkien")
                .title("Harry Potter i kamien filozoficzny").build());

        library.addBook(new BookPaperBuilder().authorFirstName("John").authorLastName("Tolkien")
                .title("Wladca pierscieni").build());

        library.addBook(new BookPaperBuilder().authorFirstName("John").authorLastName("Tolkien")
                .title("Hobbit").build());

        library.addBook(new BookSoundBuilder().authorFirstName("Lee").authorLastName("Child")
                .title("Czas przeszły").format(Format.FLAC).build());

        library.addBook(new BookSoundBuilder().authorFirstName("Remigiusz").authorLastName("Mróz")
                .title("Zaginięcie").build());

        library.addBook(new BookSoundBuilder().authorFirstName("Bernard").authorLastName("Minier")
                .title("Siostry").build());

        for (Book book : library.getBooks()){
            System.out.println(book);
        }
    }
}
