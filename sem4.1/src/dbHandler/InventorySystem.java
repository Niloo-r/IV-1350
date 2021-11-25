package dbHandler;

import model.Sale;
import util.Amount;

/**
 * represents an external inventory system
 */

public class InventorySystem {

    private ItemDTO inventory[] = new ItemDTO[2];
    private Amount price = new Amount(10);
    private Amount taxAmount = new Amount(4);

    public InventorySystem(){
        this.inventory[0] = new ItemDTO(new Amount(10),1, taxAmount,1);
        this.inventory[1] = new ItemDTO(new Amount(10), 2, taxAmount,1);
    }

    public ItemDTO findItem(int itemIdentifier){
        for (int i =0; i < inventory.length; i++){
            if (inventory[i].getItemIdentifier() == itemIdentifier){
                return inventory[i];
            }
        }
        return null;
    }

    public void saveSaleInfo(Sale sale){
        System.out.println ("Inventory system is updated");
    }
}