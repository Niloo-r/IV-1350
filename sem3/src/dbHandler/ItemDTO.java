package dbHandler;

import util.Amount;

/**
 * here we have data of an item.
 */
public class ItemDTO {
    private final Amount price;
    private final int itemIdentifier;
    private final Amount taxAmount;
    private final int quantity;
    private String itemDescription;

    /**
     * an item is represented and different detail such as price,tax and quantity is available.
     */
    public ItemDTO(Amount price, int itemIdentifier, Amount taxAmount, int quantity) {
        this.price = price;
        this.itemIdentifier = itemIdentifier;
        this.taxAmount = taxAmount;
        this.quantity = quantity;
    }




    /**
     * the mothod getPrice will get the price of the item and return the value.
     */
    public Amount getPrice() {

        return price;
    }

    /**
     * the method getItemIdentifier will get the name of the item and return the value.
     */
    public int getItemIdentifier() {
        return this.itemIdentifier;
    }

    /**
     * the method getTaxAmount will get the value of the tax and return the value.
     */
    public Amount getTaxAmount() {

        return taxAmount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}




