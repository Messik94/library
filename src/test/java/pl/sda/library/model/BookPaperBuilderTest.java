package pl.sda.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookPaperBuilderTest {

    @Test
    public void shouldBuildBookWhenBookDetailsAreDefined(){
        // given
        String authorFirstName = "Jan";
        String authorLastName = "Kowalski";
        String title = "W pustyni i w puszczy";
        Cover cover =  Cover.SOFT;
        // when
        Book book = new BookPaperBuilder()
                .authorFirstName(authorFirstName)
                .authorLastName(authorLastName)
                .title(title)
                .cover(cover)
                .build()
        ;
        // then
        assertNotNull(book);
        assertNotNull(book.getAuthor());
        assertEquals(authorFirstName, book.getAuthor().getFirstName());
        assertEquals(authorLastName, book.getAuthor().getLastName());
        assertEquals(title, book.getTitle());
        assertEquals(cover, ((BookPaper) book).getCover());
    }

}