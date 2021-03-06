package pl.sda.library.model;

import java.util.Objects;

public class BookSound extends Book implements DigitalMedium{

    private Format format;
    private int duration;

    BookSound(){ //tworzymy konstruktor bez niczego, aby tylko bookbuilder mógł tego używać

    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        BookSound audioBook = (BookSound) o;
        return duration == audioBook.duration && format == audioBook.format;
    }

    @Override public int hashCode() {
        return Objects.hash(super.hashCode(), format, duration);
    }

    @Override public String toString() {
        return "AudioBook{" + "format=" + format + ", duration=" + duration + ", author=" + author + ", title='" + title + '\'' + '}';
    }
}
