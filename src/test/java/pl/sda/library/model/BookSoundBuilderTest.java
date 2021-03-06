package pl.sda.library.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookSoundBuilderTest {

    @Test
    public void shouldBuildBookWhenBookDetailsAreDefined() {
        // given
        String authorFirstName = "Jan";
        String authorLastName = "Kowalski";
        String title = "W pustyni i w puszczy";
        Format format = Format.MP3;
        int duration = 1000;
        // when
        BookSound book = new BookSoundBuilder()
                .authorFirstName(authorFirstName)
                .authorLastName(authorLastName)
                .title(title)
                .format(format)
                .duration(duration)
                .build();
        // then
        assertNotNull(book);
        assertNotNull(book.getAuthor());
        assertEquals(authorFirstName, book.getAuthor().getFirstName());
        assertEquals(authorLastName, book.getAuthor().getLastName());
        assertEquals(title, book.getTitle());
        assertEquals(format, book.getFormat());
        assertEquals(duration, book.getDuration());
    }
}
