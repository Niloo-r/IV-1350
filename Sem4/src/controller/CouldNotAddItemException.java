package controller;

/**
 * This exception will be thrown when an error happens while adding an item.
 */
public class CouldNotAddItemException extends Exception{

    /**
     * A new instance is created with a message to be shown.
     */
    public CouldNotAddItemException(String message, Exception cause) {
        super(message, cause);
    }
}

