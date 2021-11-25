package dbHandler;

import model.DiscountRules;

/**
 * here are different catalogs created
 */
public class CatalogCreator {
    private DiscountRules discountRules;
    private ItemCatalog itemCatalog;

    /**
     * a new instance
     */
    public CatalogCreator(){
        discountRules = new DiscountRules();
        itemCatalog = new ItemCatalog();
    }

    /**
     * the method getDiscounCatalog will simply get the value of discountCatalog and return the value.
     */
    public DiscountRules getDiscountCatalog() {
        return discountRules;
    }

    /**
     *the function getItemCatalog will get the value of itemCatalog and return the value.
     */
    public ItemCatalog getItemCatalog() {
        return itemCatalog;
    }
}
