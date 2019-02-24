package pl.sda.library.command;

import pl.sda.library.model.Library;
import pl.sda.library.model.Medium;
import pl.sda.library.model.MediumState;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class BorrowMultimediaCommand implements Command{

    private final Library<Medium> library;
    private final PrintStream printStream;

    public BorrowMultimediaCommand(Library<Medium> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Title: ");
        String title = scanner.nextLine();
        printStream.println("First name: ");
        String firstName = scanner.nextLine();
        printStream.println("Last name: ");
        String lastName = scanner.nextLine();
        Optional<Medium> medium = library.getMedia().stream()
                .filter(m -> Objects.equals(m.getTitle(), title))
                .findFirst();
        //medium.ifPresent(m -> m.getState().borrowMedium(firstName, lastName));
        Optional<MediumState> state = medium.map(m -> m.getState().borrowMedium(firstName, lastName));
        medium.ifPresent(m -> m.setState(state.get()));

        if (!medium.isPresent()) {
            printStream.println("Książka nie istnieje!");
        }
    }
}
