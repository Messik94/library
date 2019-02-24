package pl.sda.library.model;

import java.io.PrintStream;
import java.util.Objects;

public class BorrowedState implements MediumState {

    private final PrintStream printStream;
    private String firstName;
    private String lastName;

    public BorrowedState(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public MediumState borrowMedium(String firstName, String lastName) {
        //System.out.println("Książka już jest wypożyczona!");
        printStream.println("Książka już jest wypożyczona!");
        return this;
    }

    @Override
    public MediumState returnMedium() {
        return new ReturnedState(printStream);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowedState that = (BorrowedState) o;
        return Objects.equals(printStream, that.printStream) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printStream, firstName, lastName);
    }

    @Override
    public String toString() {
        return "BorrowedState{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
