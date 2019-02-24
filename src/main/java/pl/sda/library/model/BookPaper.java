package pl.sda.library.model;

import java.util.Objects;

public class BookPaper extends Book implements PaperMedium{

    private Cover cover;
    private int pageCount;

    BookPaper() {

    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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
        return "BookPaper{" +
                "cover=" + cover +
                ", pageCount=" + pageCount +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", state=" + state +
                '}';
    }
}
