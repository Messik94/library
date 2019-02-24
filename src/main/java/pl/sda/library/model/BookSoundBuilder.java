package pl.sda.library.model;

import java.util.Optional;

public class BookSoundBuilder {

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private Format format;
    private int duration;

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

    public BookSoundBuilder duration(int duration) {
        this.duration = duration;
        return this;
    }

    public BookSound build(){
        BookSound book = new BookSound();
        Creator author = new Creator();
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
        book.setDuration(duration);
        book.setState(new ReturnedState());
        return book;
    }
}
