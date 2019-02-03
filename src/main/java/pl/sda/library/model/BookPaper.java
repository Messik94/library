package pl.sda.library.model;

import java.util.Objects;

public class BookPaper extends Book {

    private Cover cover;

    BookPaper() {

    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookPaper bookPaper = (BookPaper) o;
        return cover == bookPaper.cover;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cover);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", cover=" + cover.getName() +
                '}';
    }
}
