/*package dbHandler;

 /**
     * This will be thrown if the wanted item does not exists
     */
   /* public class ItemNotFoundException extends Exception {
       String itemIdentifier;

        /**
         * A new instance is created so we can know exactly which item identifier does not exist.
         * @param itemIdentifier
         */
/* public ItemNotFoundException(String itemIdentifier){
            super("Given item identifer: " + itemIdentifier + ", doesn't exist.");
            this.itemIdentifier = itemIdentifier;
        }

        /**
         * Gets the item identifier that doesn't exist.
         *
         * @return The item identifier that doesn't exists.
         */
       /* public String getItemIdentiferThatDoesntExist(){
            return itemIdentifier;
        }
    }
    */
package dbHandler;

/**
 * Checked exception invoked when an item ID that does not match in item is
 * used.
 */
public class ItemNotFoundException extends Exception {
    /**
     * The defult message for the exception.
     */
    public ItemNotFoundException() {
        super("User interface:\tInvalid item ID. Please use a diffrent ID\nLog file:\tInvalid item iD input by user. Item ID does not match existing items in storage");
    }

    /**
     * The exception with a custom message.
     *
     * @param message The message.
     */
    public ItemNotFoundException(String message) {
        super(message);
    }

}



