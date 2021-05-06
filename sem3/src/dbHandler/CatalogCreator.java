package dbHandler;

import model.DiscountRules;

/**
 * Represents a creator that consists of different catalogs.
 */
public class CatalogCreator {
    private DiscountRules discountRules;
    private ItemCatalog itemCatalog;

    /**
     * Creates a new instance
     */
    public CatalogCreator(){
        discountRules = new DiscountRules();
        itemCatalog = new ItemCatalog();
    }

    /**
     * Gets the value of discountCatalog.
     *
     * @return The value discountCatalog.
     */
    public DiscountRules getDiscountCatalog() {
        return discountRules;
    }

    /**
     * Gets the value of itemCatalog.
     * @return  The value of itemCatalog.
     */
    public ItemCatalog getItemCatalog() {
        return itemCatalog;
    }
}
