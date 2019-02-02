package pl.sda.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookBuilderTest {

    @Test
    public void shouldBuildBookWhenBookDetailsAreDefined(){
        // given
        String authorFirstName = "Jan";
        String authorLastName = "Kowalski";
        String title = "W pustyni i w puszczy";
        // when
        Book book = new BookBuilder().authorFirstName(authorFirstName)
                .authorLastName(authorLastName)
                .title(title)
                .build()
        ;
        // then
        assertNotNull(book);
        assertNotNull(book.getAuthor());
        assertEquals(authorFirstName, book.getAuthor().getFirstName());
        assertEquals(authorLastName, book.getAuthor().getLastName());
    }

}