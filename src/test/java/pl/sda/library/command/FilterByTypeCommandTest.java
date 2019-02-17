package pl.sda.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.sda.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class FilterByTypeCommandTest {

    private InputStream inputStream;

    @Before public void setUp() throws Exception{
        inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Movie\n".getBytes()));
    }

    @After public void tearDown(){
        System.setIn(inputStream);
    }

    @Test
    public void shouldDisplayMoviesWhenFilterByMovie() throws IOException {
        //given
        Book book = new BookPaperBuilder()
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .title("W pustyni i w puszczy")
                .cover(Cover.HARD)
                .pageCount(100)
                .build();
        Movie movie = new MovieBuilder().title("W pustyni i w puszczy")
                .directorFirstName("Andrzej")
                .directorLastName("Wajda")
                .duration(100)
                .build();
        Movie movie2 = new MovieBuilder().title("Człowiek z marmuru")
                .directorFirstName("Andrzej")
                .directorLastName("Wajda")
                .duration(111)
                .build();
        Library<Medium> library = new Library<>();
        library.addMedium(book);
        library.addMedium(movie);
        library.addMedium(movie2);
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new FilterByTypeCommand(library, printStreamMock);

        //when
        command.execute();
        //then
        verify(printStreamMock, times(1))
                .println("Type: ");
        verify(printStreamMock, times(1))
                .println(movie);
        verify(printStreamMock, times(1))
                .println(movie2);
        verify(printStreamMock, never()).println(book);
    }
}