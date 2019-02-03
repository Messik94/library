package pl.sda.library.model;

//import java.util.Optional;

public class BookPaperBuilder{

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private Cover cover;

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

    public BookPaper build() {
        BookPaper book = new BookPaper();
        Author author = new Author();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
//        Optional<Cover> coverOptional = Optional.ofNullable(this.cover);
//        book.setCover(coverOptional.orElse(Cover.SOFT));
//        można użyć tego powyżej (optional) lub tego poniżej (if-else)
//
//        trzecia opcja:
//        book.setCover(Optional.ofNullable(this.cover).orElse(Cover.SOFT));

        if (cover != null) {
            book.setCover(cover);
        }
        else{
            book.setCover(Cover.SOFT);
        }
        return book;
    }
}
