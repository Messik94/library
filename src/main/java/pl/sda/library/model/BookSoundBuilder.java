package pl.sda.library.model;

import java.util.Optional;

public class BookSoundBuilder {

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private Format format;

    public BookSoundBuilder authorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public BookSoundBuilder authorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public BookSoundBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookSoundBuilder format(Format format){
        this.format = format;
        return this;
    }

    public BookSound build(){
        BookSound book = new BookSound();
        Author author = new Author();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);

        book.setFormat(Optional.ofNullable(format).orElse(Format.MP3));

//        if (format != null) {
//            book.setFormat(format);
//        }
//        else{
//            book.setFormat(Format.MP3);
//        }
        return book;
    }
}
