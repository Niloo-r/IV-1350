package dbHandler;

import model.ItemDTO;
import model.Sale;

public class InventorySystem {
    ItemDTO inventory[] = new ItemDTO[3];

    public InventorySystem() {
        inventory[0] = new ItemDTO(10.0, 0, "Orange", 12.5, 0);
        inventory[1] = new ItemDTO(10.0, 1, "Cherry", 12.5, 0);
        inventory[2] = new ItemDTO(20.0, 2, "Blueberry", 12.5, 0);

    }

    public ItemDTO findItem(int itemIdentifier) throws ItemNotFoundException, DatabaseErrorException {
        for(int i = 0; i < inventory.length; i++) {
            if (itemIdentifier == 4){
                throw new DatabaseErrorException();
            }
            if(inventory[i].getItemIdentifier() == itemIdentifier) {
                return inventory[i];
            }
        }

        throw new ItemNotFoundException(itemIdentifier);
    }

    public void saveSaleInformation(Sale sale) {
        System.out.println("(Inventorysystem is updated)");

    }

    public void reset() {
        inventory[0].resetQuantity();
        inventory[1].resetQuantity();
        inventory[2].resetQuantity();
    }
}

