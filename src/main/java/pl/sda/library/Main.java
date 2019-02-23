package pl.sda.library;

import pl.sda.library.command.Command;
import pl.sda.library.command.DisplayMultimediaCommand;
import pl.sda.library.command.FilterByTypeCommand;
import pl.sda.library.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library<Medium> library = createLibrary();
        Scanner scanner = new Scanner(System.in);
        Map<String, Command> commands = new HashMap<>();
        commands.put("exit", () -> System.exit(0));
        commands.put("display", new DisplayMultimediaCommand(library, System.out));
        commands.put("filter", new FilterByTypeCommand(library, System.out));
        while(true){
            System.out.println("Podaj komende: ");
            String commandName = scanner.nextLine();
            Command command = commands.get(commandName);
            Optional.ofNullable(command).ifPresent(Command::execute);
        }

//        library.getMedia().forEach(System.out::println);
//
//        for (Medium medium : library.getMedia()){
//            System.out.println(medium);
//        }
    }

    private static Library<Medium> createLibrary() {
        Library<Medium> library = new Library<>(); // drugie <> nie trzeba Medium
        library.addMedium(new BookPaperBuilder()
                .authorFirstName("Carol")
                .authorLastName("Lewis")
                .title("Lew, czarownica i stara szafa")
                .cover(Cover.HARD)
                .build())
        ;

        library.addMedium(new BookPaperBuilder().authorFirstName("John").authorLastName("Tolkien")
                .title("Harry Potter i kamien filozoficzny").build());

        library.addMedium(new BookPaperBuilder().authorFirstName("John").authorLastName("Tolkien")
                .title("Wladca pierscieni").build());

        library.addMedium(new BookPaperBuilder().authorFirstName("John").authorLastName("Tolkien")
                .title("Hobbit").build());

        library.addMedium(new BookSoundBuilder().authorFirstName("Lee").authorLastName("Child")
                .title("Czas przeszły").format(Format.FLAC).build());

        library.addMedium(new BookSoundBuilder().authorFirstName("Remigiusz").authorLastName("Mróz")
                .title("Zaginięcie").build());

        library.addMedium(new BookSoundBuilder().authorFirstName("Bernard").authorLastName("Minier")
                .title("Siostry").build());

        library.addMedium(new MagazineBuilder().title("Motor").number(15).pageCount(32).build());

        library.addMedium(new MagazineBuilder().title("Newsweek").number(254).pageCount(124).build());

        library.addMedium(new MagazineBuilder().title("Gazeta wyborcza").number(37).pageCount(36).build());

        library.addMedium(new MovieBuilder().title("Skazani na Shawshank").directorFirstName("Frank")
                .directorLastName("Darabont").duration(120).build());

        library.addMedium(new MovieBuilder().title("Nietykalni").directorFirstName("Olivier")
                .directorLastName("Nakache").duration(110).build());

        library.addMedium(new MovieBuilder().title("Zielona mila").directorFirstName("Frank")
                .directorLastName("Darabont").duration(180).build());

        return library;
    }
}
