package pl.sda.library.command;

import org.junit.Test;
import org.mockito.Mockito;
import pl.sda.library.model.*;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class DisplayMultimediaCommandTest {

    @Test
    public void shouldDisplayMultimediaWhenSomeMultimediaIsAvailable(){
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
        Library<Medium> library = new Library<>();
        library.addMedium(book);
        library.addMedium(movie);
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new DisplayMultimediaCommand(library, printStreamMock);
        //when
        command.execute();
        //then
        verify(printStreamMock, times(1))
                .println(book);

        verify(printStreamMock, times(1))
                .println(movie);
    }
}