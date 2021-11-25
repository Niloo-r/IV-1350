package dbHandler;

/**
 * This exception will be thrown if the search for an item fails and can not return the searched item.
 */
public class ItemNotFoundException extends Exception {

    /**
     * A new instance of the exception is created with a message shown.
     * @param itemIdentifier - The itemidentifier that could not be found.
     */
    public  ItemNotFoundException (int itemIdentifier){
        super("Item with ID: " + itemIdentifier + " not found.");
    }

}
