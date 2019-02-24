package pl.sda.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.sda.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AddNewMediumCommandTest {

    public static final String TEST_AUDIO_BOOK_INPUT = "BookSound\nW pustyni i w puszczy\nHenryk\nSienkiewicz\nMP3\n100\n";
    public static final String TEST_PAPER_BOOK_INPUT = "BookPaper\nW pustyni i w puszczy\nHenryk\nSienkiewicz\nHARD\n300\n";
    public static final String TEST_MOVIE_INPUT = "Movie\nCzłowiek z żelaza\nAndrzej\nWajda\n120\n";
    public static final String TEST_MAGAZINE_INPUT = "Magazine\nProgramista\n10\n100\n";
    private InputStream inputStream;

    @Before
    public void setUp() throws Exception{
        inputStream = System.in;
        System.setIn(new ByteArrayInputStream(TEST_AUDIO_BOOK_INPUT.getBytes()));
    }

    @After
    public void tearDown(){
        System.setIn(inputStream);
    }

    @Test
    public void shouldCreateBookAudioWhenBookAudioTypeWasTyped() {
        //given
        Library<Medium> library = new Library<>();
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new AddNewMediumCommand(library, printStreamMock);
        //when
        command.execute();
        //then
        BookSound bookSound = new BookSoundBuilder()
                .title("W pustyni i w puszczy")
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .format(Format.MP3)
                .duration(100)
                .build();
        Library<Medium> expectedLibrary = new Library<>();
        expectedLibrary.addMedium(bookSound);

        assertEquals(expectedLibrary, library);

        verify(printStreamMock, times(1))
                .println("Type: ");
        verify(printStreamMock, times(1))
                .println("Title: ");
        verify(printStreamMock, times(1))
                .println("Author first name: ");
        verify(printStreamMock, times(1))
                .println("Author last name: ");
        verify(printStreamMock, times(1))
                .println("Format: ");
        verify(printStreamMock, times(1))
                .println("Duration: ");
    }

    @Test
    public void shouldCreateBookPaperWhenBookPaperTypeWasTyped() {
        //given
        System.setIn(new ByteArrayInputStream(TEST_PAPER_BOOK_INPUT.getBytes()));
        Library<Medium> library = new Library<>();
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new AddNewMediumCommand(library, printStreamMock);
        //when
        command.execute();
        //then
        BookPaper bookPaper = new BookPaperBuilder()
                .title("W pustyni i w puszczy")
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .cover(Cover.HARD)
                .pageCount(300)
                .build();
        Library<Medium> expectedLibrary = new Library<>();
        expectedLibrary.addMedium(bookPaper);

        assertEquals(expectedLibrary, library);

        verify(printStreamMock, times(1))
                .println("Type: ");
        verify(printStreamMock, times(1))
                .println("Title: ");
        verify(printStreamMock, times(1))
                .println("Author first name: ");
        verify(printStreamMock, times(1))
                .println("Author last name: ");
        verify(printStreamMock, times(1))
                .println("Cover: ");
        verify(printStreamMock, times(1))
                .println("Page count: ");
    }

    @Test
    public void shouldCreateMovieWhenMovieTypeWasTyped() {
        //given
        System.setIn(new ByteArrayInputStream(TEST_MOVIE_INPUT.getBytes()));
        Library<Medium> library = new Library<>();
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new AddNewMediumCommand(library, printStreamMock);
        //when
        command.execute();
        //then
        Movie movie = new MovieBuilder()
                .title("Człowiek z żelaza")
                .directorFirstName("Andrzej")
                .directorLastName("Wajda")
                .duration(120)
                .build();
        Library<Medium> expectedLibrary = new Library<>();
        expectedLibrary.addMedium(movie);

        assertEquals(expectedLibrary, library);

        verify(printStreamMock, times(1))
                .println("Type: ");
        verify(printStreamMock, times(1))
                .println("Title: ");
        verify(printStreamMock, times(1))
                .println("Director first name: ");
        verify(printStreamMock, times(1))
                .println("Director last name: ");
        verify(printStreamMock, times(1))
                .println("Duration: ");
    }

    @Test
    public void shouldCreateMagazineWhenMagazineTypeWasTyped() {
        //given
        System.setIn(new ByteArrayInputStream(TEST_MAGAZINE_INPUT.getBytes()));
        Library<Medium> library = new Library<>();
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new AddNewMediumCommand(library, printStreamMock);
        //when
        command.execute();
        //then
        Magazine magazine = new MagazineBuilder()
                .title("Programista")
                .number(10)
                .pageCount(100)
                .build();
        Library<Medium> expectedLibrary = new Library<>();
        expectedLibrary.addMedium(magazine);

        assertEquals(expectedLibrary, library);

        verify(printStreamMock, times(1))
                .println("Type: ");
        verify(printStreamMock, times(1))
                .println("Title: ");
        verify(printStreamMock, times(1))
                .println("Number: ");
        verify(printStreamMock, times(1))
                .println("Page count: ");
    }
}