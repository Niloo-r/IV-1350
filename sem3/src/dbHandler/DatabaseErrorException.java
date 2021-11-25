package dbHandler;

/**
 * This unchecked exception indicates that a connection to the external database
 * could not be established.
 */
public class DatabaseErrorException extends Exception {
    /**
     * The exception with default message.
     */
    public DatabaseErrorException() {
        super("User interface:\tConnection to database lost. please try again\nLog file:\tConnection Error. Database server not responding at: "
                + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
    }

    /**
     * The exception with a custom message.
     *
     * @param message The message.
     */
    public DatabaseErrorException(String message) {
        super(message);
    }

}
