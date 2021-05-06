package dbHandler;

import util.Amount;

/**
 * Represents the data of an item.
 */
public class ItemDTO {
    private final Amount price;
    private final int itemIdentifier;
    private final Amount taxAmount;
    private final int quantity;
    private String itemDescription;

    /**
     * Creates a new instance representing a particular item.
     *  @param price     The price of the item.
     * @param itemIdentifier
     * @param taxAmount The tax amount of the item.
     */
    public ItemDTO(Amount price, int itemIdentifier, Amount taxAmount, int quantity) {
        this.price = price;
        this.itemIdentifier = itemIdentifier;
        this.taxAmount = taxAmount;
        this.quantity = quantity;
    }




    /**
     * Get value of price.
     *
     * @return the value of price.
     */
    public Amount getPrice() {

        return price;
    }

    /**
     * Get the value of itemName.
     *
     * @return the value of itemName.
     */
    public int getItemIdentifier() {
        return this.itemIdentifier;
    }

    /**
     * Get the value of taxAmount.
     *
     * @return the value of taxAmount.
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




