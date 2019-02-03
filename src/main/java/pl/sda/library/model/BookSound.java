package pl.sda.library.model;

import java.util.Objects;

public class BookSound extends Book {

    private Format format;

    BookSound(){ //tworzymy konstruktor bez niczego, aby tylko bookbuilder mógł tego używać

    }

    public Format getFormat(){
        return format;
    }

    public void setFormat(Format format){
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookSound bookSound = (BookSound) o;
        return format == bookSound.format;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), format);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", format=" + format +
                '}';
    }
}
