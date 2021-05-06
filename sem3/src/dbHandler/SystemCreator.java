package dbHandler;

/**
 * Systems are created. Accounting and inventory systems are necessary.
 */
public class SystemCreator {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;

    /**
     * the systemCreator is created
     */
    public SystemCreator(){
        accountingSystem = new AccountingSystem();
        inventorySystem = new InventorySystem();
    }

    /**
     * gets the value of the accounting system and return the value.
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    /**
     * Gets the value of inventorySystem and return the value.
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }
}
