package dbHandler;

public class Rule {
    private int itemID = -1;
    private double discount = 0;

    /**
     * This is only here to simulate a system with discount rules
     *
     * @param itemID   The item ID
     * @param discount The discount amount for the item
     */

    public Rule(int itemID, double discount) {
        this.itemID = itemID;
        this.discount = discount;
    }

    /**
     * Gets the item ID.
     *
     * @return The itemI D
     */
    public int getItemID() {
        return this.itemID;
    }

    /**
     * Gets the discount value.
     *
     * @return The discount value
     */
    public double getDiscount() {
        return this.discount;
    }

}
