package pl.sda.library.command;

import pl.sda.library.model.MagazineBuilder;
import pl.sda.library.model.Medium;

import java.io.PrintStream;
import java.util.Scanner;

public class CreateMagazineCommandStrategy implements AddNewMediumStrategy{

    private static final String MAGAZINE = "Magazine";

    @Override
    public Medium createMedium(Scanner scanner, PrintStream printStream) {
        printStream.println("Title: ");
        String title = scanner.nextLine();
        printStream.println("Number: ");
        int number = scanner.nextInt();
        printStream.println("Page count: ");
        int pageCount = scanner.nextInt();
        scanner.nextLine();

        return new MagazineBuilder()
                .title(title)
                .number(number)
                .pageCount(pageCount)
                .build();
    }

    @Override
    public boolean isTypeCorrect(String type) {
        return MAGAZINE.equals(type);
    }
}
