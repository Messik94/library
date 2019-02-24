package pl.sda.library.model;

import org.junit.Test;
import org.mockito.Matchers;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReturnedStateTest {

    @Test
    public void shouldBorrowBookWhenIsReturned(){
        //given
        PrintStream printStreamMock = mock(PrintStream.class);
        MediumState state = new ReturnedState(printStreamMock);
        String firstName = "Jan";
        String lastName = "Kowalski";
        //when
        MediumState mediumState = state.borrowMedium(firstName, lastName);
        //then
        assertTrue(mediumState instanceof BorrowedState);
        assertEquals(firstName, ((BorrowedState) mediumState).getFirstName());
        assertEquals(lastName, ((BorrowedState) mediumState).getLastName());
        verify(printStreamMock, never()).println(Matchers.anyString());
    }

    @Test
    public void shouldNotReturnBookWhenIsReturned(){
        //given
        PrintStream printStreamMock = mock(PrintStream.class);
        MediumState state = new ReturnedState(printStreamMock);
        //when
        MediumState mediumState = state.returnMedium();
        //then
        assertTrue(mediumState instanceof ReturnedState);
        verify(printStreamMock, only())
                .println("Nie można zwrócić niewypożyczonej książki!");
    }
}