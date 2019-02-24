package pl.sda.library.command;

import pl.sda.library.model.BookSound;
import pl.sda.library.model.BookSoundBuilder;
import pl.sda.library.model.Format;
import pl.sda.library.model.Medium;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class CreateBookAudioCommandStrategy implements AddNewMediumStrategy {

    public static final String AUDIO_BOOK = BookSound.class.getSimpleName();

    @Override
    public Medium createMedium(Scanner scanner, PrintStream printStream) {
        printStream.println("Title: ");
        String title = scanner.nextLine();
        printStream.println("Author first name: ");
        String authorFirstName = scanner.nextLine();
        printStream.println("Author last name: ");
        String authorLastName = scanner.nextLine();
        printStream.println("Format: ");
        String format = scanner.nextLine();
        printStream.println("Duration: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        return new BookSoundBuilder()
                .title(title)
                .authorFirstName(authorFirstName)
                .authorLastName(authorLastName)
                .format(Format.valueOf(format))
                .duration(duration)
                .build();
    }

    @Override
    public boolean isTypeCorrect(String type) {
        return Objects.equals(type, AUDIO_BOOK);
    }
}
