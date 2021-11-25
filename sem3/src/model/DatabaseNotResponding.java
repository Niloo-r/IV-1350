package model;

/**
 * This unchecked exception indicates that a connection to the external database
 * could not be established.
 */
public class DatabaseNotResponding extends Exception {
    /**
     * The exception with default message.
     */
    public DatabaseNotResponding() {
        super("User interface:\tConnection to database lost. please try again\nLog file:\tConnection Error. Database server not responding at: "
                + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
    }

    /**
     * The exception with a custom message.
     *
     * @param message The message.
     */
    public DatabaseNotResponding(String message) {
        super(message);
    }

}
