package pl.sda.library.command;

import pl.sda.library.model.*;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class CreateBookPaperCommandStrategy implements AddNewMediumStrategy {

    public static final String PAPER_BOOK = BookPaper.class.getSimpleName();

    @Override
    public Medium createMedium(Scanner scanner, PrintStream printStream) {
        printStream.println("Title: ");
        String title = scanner.nextLine();
        printStream.println("Author first name: ");
        String authorFirstName = scanner.nextLine();
        printStream.println("Author last name: ");
        String authorLastName = scanner.nextLine();
        printStream.println("Cover: ");
        String cover = scanner.nextLine();
        printStream.println("Page count: ");
        int pageCount = scanner.nextInt();
        scanner.nextLine();

        return new BookPaperBuilder()
                .title(title)
                .authorFirstName(authorFirstName)
                .authorLastName(authorLastName)
                .cover(Cover.valueOf(cover))
                .pageCount(pageCount)
                .build();
    }

    @Override
    public boolean isTypeCorrect(String type) {
        return Objects.equals(type, PAPER_BOOK);
    }
}