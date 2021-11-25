package dbHandler;

import util.Amount;

import java.util.HashMap;

/**
 * represnets an ItemCatalog
 */
public class ItemCatalog {
    private static HashMap<String, ItemDTO> itemList = new HashMap<>();


    ItemCatalog(){
        addItems();
    }

    /**
     * will check if the item exists in data base or the catalog
     * return true if it exists and false if it doesnt
     * @param itemIdentifier
     */
    public static boolean itemExists(ItemDTO itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }

    /**
     * the method getItem will get the description of an item using itemIdentifier and quantity of the item
     * and returns the value
     * if the item does not found null will be returned.
     */
    public static Item getItem(ItemDTO itemIdentifier, Amount quantity){
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
