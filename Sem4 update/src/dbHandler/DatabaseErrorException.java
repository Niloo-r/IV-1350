package dbHandler;

public class DatabaseErrorException extends RuntimeException{

    /**
     * A new instance is created of the exception with a message to be shown.
     */
    public DatabaseErrorException(){
        super("Database error. (Shown only to developers)");
    }
}
