package pl.sda.library.command;

import pl.sda.library.model.Medium;
import pl.sda.library.model.MovieBuilder;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class CreateMovieCommandStrategy implements AddNewMediumStrategy {

    private static final String MOVIE = "Movie";

    @Override
    public Medium createMedium(Scanner scanner, PrintStream printStream) {
        printStream.println("Title: ");
        String title = scanner.nextLine();
        printStream.println("Director first name: ");
        String directorFirstName = scanner.nextLine();
        printStream.println("Director last name: ");
        String directorLastName = scanner.nextLine();
        printStream.println("Duration: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        return new MovieBuilder()
                .title(title)
                .directorFirstName(directorFirstName)
                .directorLastName(directorLastName)
                .duration(duration)
                .build();
    }

    @Override
    public boolean isTypeCorrect(String type) {
        return Objects.equals(type, MOVIE);
    }
}
