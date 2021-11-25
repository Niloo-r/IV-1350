package model;

public class ItemDTO {
    private double price;
    private int itemIdentifier;
    private String itemDescription;
    private double tax;
    private int quantity;

    public ItemDTO (double price, int itemIdentifier, String itemDescription, double tax, int quantity){
        this.price = price;
        this.itemIdentifier = itemIdentifier;
        this.itemDescription = itemDescription;
        this.tax = tax;
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public int getItemIdentifier() {
        return this.itemIdentifier;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public double getTax() {
        return this.tax;
    }

    public int getQuantity() {
        return this.quantity;
    }

    /*public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }*/

    public int updateQuantity(int quantity) {
        this.quantity += quantity;
        return this.quantity;
    }

    public void resetQuantity() {
        this.quantity = 0;
    }
}

