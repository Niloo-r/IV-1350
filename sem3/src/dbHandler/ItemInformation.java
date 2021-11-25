package dbHandler;

public class ItemInformation {
    private String name = "Name missing";
    private String description = "Description missing";
    private int itemID = -1;
    private double itemVAT = 0;
    private double price = 0;

    public ItemInformation() {

    }

    public ItemInformation(String name, String description, int itemID, double itemVAT, double price) {
        this.name = name;
        this.description = description;
        this.itemID = itemID;
        this.itemVAT = itemVAT;
        this.price = price;
    }

    /**
     * Gets the item ID.
     *
     * @return The item ID.
     */
    public int getItemID() {
        return this.itemID;
    }

    /**
     * Gets the items name.
     *
     * @return The items name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the items description
     *
     * @return The items description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the items VAT.
     *
     * @return The items VAT.
     */
    public double getVAT() {
        return this.itemVAT;
    }

    /**
     * Gets the items price
     *
     * @return The items price
     */
    public double getPrice() {
        return this.price;
    }

}
