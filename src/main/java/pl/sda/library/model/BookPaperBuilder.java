package pl.sda.library.model;

//import java.util.Optional;

import java.util.Optional;

public class BookPaperBuilder{

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private Cover cover;
    private int pageCount;

    public BookPaperBuilder authorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public BookPaperBuilder authorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public BookPaperBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookPaperBuilder cover(Cover cover){
        this.cover = cover;
        return this;
    }

    public BookPaperBuilder pageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public BookPaper build() {
        BookPaper book = new BookPaper();
        Creator author = new Creator();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
//        Optional<Cover> coverOptional = Optional.ofNullable(this.cover);
//        book.setCover(coverOptional.orElse(Cover.SOFT));
//        można użyć tego powyżej (optional) lub tego poniżej (if-else)
//
//        if (cover != null) {
//            book.setCover(cover);
//        }
//        else{
//            book.setCover(Cover.SOFT);
//        }
//        trzecia opcja:
        book.setCover(Optional.ofNullable(this.cover).orElse(Cover.SOFT));
        book.setPageCount(pageCount);
        book.setState(new ReturnedState());
        return book;
    }
}
