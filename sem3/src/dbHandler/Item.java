package dbHandler;

import util.Amount;

/**
 * Represents an Item.
 */
public class Item {
    private ItemDTO itemDescription;
    private String itemIdentifier;
    private Amount quantity;

    /**
     * a new instance is created and represents an item.
     *
     * @param itemDescription represents the description of the item.
     * @param itemIdentifier is the identifier of the item.
     * @param quantity represents how many of each item we have.
     */
    public Item(ItemDTO itemDescription, String itemIdentifier, Amount quantity) {
        this.itemDescription = itemDescription;
        this.itemIdentifier = itemIdentifier;
        this.quantity = quantity;
    }

    /**
     * if there is more than one of an item then the quantity will increase.
     *it will be added to the quantity.
     */
    public void increaseQuantity(Amount otherQuantity){
        this.quantity = this.quantity.plus(otherQuantity);
    }

    /**
     * in case we want to decrease the quantity
     * it will we subtracted from quantity
     */
    public void decreaseQuantity(Amount otherQuantity){
        this.quantity = this.quantity.minus(otherQuantity);
    }

    /**
     * gets the quantity value, in other word, how many of an item we have
     */
    public Amount getQuantity() {
        return quantity;
    }

    /**
     * gets the value of the itemIdentifier and return the value.
     */
    public String getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * makes a String
     */
    @Override
    public String toString() {
        String builder = ("item identifier: " + itemIdentifier) +
                "quantity: " + quantity +
                "item description: " + itemDescription.toString();
        return builder;
    }

    /**
     * compare all instances but quantity
     * return true if they are equal and false if they are not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Item other = (Item) obj;
        if (!this.itemDescription.equals(other.itemDescription)){
            return false;
        }
        if (!this.itemIdentifier.equals(other.itemIdentifier)){
            return false;
        }
        return true;
    }

    public ItemDTO getItemDTO() {
        return itemDescription;
    }
}
