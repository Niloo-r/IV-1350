package dbHandler;

import util.Amount;

import java.util.HashMap;

/**
 * represnets an ItemCatalog
 */
public class ItemCatalog {
    private HashMap<String, ItemDTO> itemList = new HashMap<>();


    ItemCatalog(){
        addItems();
    }

    /**
     * will check if the item exists in data base or the catalog
     * return true if it exists and false if it doesnt
     */
    public boolean itemExists(String itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }

    /**
     * the method getItem will get the description of an item using itemIdentifier and quantity of the item
     * and returns the value
     * if the item does not found null will be returned.
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
