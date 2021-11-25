package DTO;

public class ItemInformationDTO {
    private String name = null;
    private String description = null;
    private int itemID = -1;
    private double VAT = 0;
    private double price = 0;

    public ItemInformationDTO(String name, String description, int itemID, double VAT, double price) {
        this.name = name;
        this.description = description;
        this.itemID = itemID;
        this.VAT = VAT;
        this.price = price;

    }
    /*
     * Returns the items name.
     *
     * @return The items name.
     */

    public String getName() {
        return this.name;
    }

    /*
     * Gets the item description.
     *
     * @return The item description.
     */
    public String getDescription() {
        return this.description;
    }

    /*
     * Gets the items ID.
     *
     * @return The items ID.
     */
    public int getItemID() {
        return this.itemID;
    }

    /*
     * Gets the items VAT.
     *
     * @return The items VAT value.
     */
    public double getVAT() {
        return this.VAT;
    }

    /*
     * Represents the iteminformation as a String
     *
     * @return The item information as a String.
     */
    public String toString() {

        return "Name: " + this.name + "\nDescription: " + this.description + "\nPrice: " + this.price + "\nVAT: "
                + this.VAT + "\nitem ID: " + this.itemID;
    }

    /*
     * Gets the item price.
     *
     * @return the item price
     */
    public double getPrice() {
        return this.price;
    }

}
