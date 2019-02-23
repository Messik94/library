package pl.sda.library.command;

import pl.sda.library.model.Library;
import pl.sda.library.model.Medium;

import java.io.PrintStream;
import java.util.Scanner;

public class FilterByTypeCommand implements Command {

    private final Library<Medium> library;
    private final PrintStream printStream;

    public FilterByTypeCommand(Library<Medium> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Type: ");
        String type = scanner.nextLine();
        library.getMedia().stream()
                .filter(mediumm -> mediumm.getType().equals(type))
                .forEach(printStream::println);

//        for (Medium medium : library.getMedia()){
//            if (medium.getClass().getSimpleName().equals(type)){
//                printStream.println(medium);
//            }
//        }
    }
}
