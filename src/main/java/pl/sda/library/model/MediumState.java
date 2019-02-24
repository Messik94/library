package pl.sda.library.model;

public interface MediumState {

    MediumState borrowMedium(String firstName, String lastName);

    MediumState returnMedium();
}
