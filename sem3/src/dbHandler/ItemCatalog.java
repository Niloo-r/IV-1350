package dbHandler;

import util.Amount;

import java.util.HashMap;

/**
 * Represents a dummy item database.
 */
public class ItemCatalog {
    private HashMap<String, ItemDTO> itemList = new HashMap<>();

    /**
     *  Creates a instance of a dummy item database.
     */
    ItemCatalog(){
        addItems();
    }

    /**
     *  Checks if the searched itemIdentifier exists in the database.
     *
     * @param itemIdentifier The looked item.
     * @return If item exists <code>true</code> else <code>false</code>
     */
    public boolean itemExists(String itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }

    /**
     * Gets the item description of the specified itemIdentifier.
     * Returns an item with the specified quantity.
     *
     * @param itemIdentifier The identifier of an item.
     * @param quantity The amount of items.
     * @return An item with it's itemDescription and quantity or null if the identifier didn't exist..
     */
    public Item getItem(String itemIdentifier, Amount quantity){
        if (itemExists(itemIdentifier)){
            return new Item(itemList.get(itemIdentifier), itemIdentifier, quantity);
        }
        return null;
    }

    private void addItems() {
        itemList.put("tandkräm", new ItemDTO(new Amount(20), 1, new Amount(10), 1));
        itemList.put("tandborste", new ItemDTO(new Amount(20), 2, new Amount(10), 2));
    }
}
