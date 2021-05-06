package model;

import dbHandler.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * this will be a point of sale between customer and cashier
 */
public class Sale {
    private Total total;
    private HashMap<String, Item> items = new HashMap<>();
    private ItemDTO itemDTO ;


    /**
     * a new instance is created and will represent a sale
     */
    public Sale(){
        this.total = new Total();
    }

    /**
     * the method will get the value of total and return the value.
     */
    public Total getTotal() {
        return total;
    }

    /**
     * Gets the HashMap items.
     * HashMap: stores data in (key, value) pairs.
     */
    public HashMap<String, Item> getItems(){
        return items;
    }

    /**
     * null items wont be taken.
     * the current sale will get updated, also how many items there are and the running total.
     */
    public String updateSale(Item item){
        if (itemListContains(item)) {
            updateItemQuantityAndTotal(item);
        } else {
            addItemAndUpdateTotal(item);
        }
        return item.getItemIdentifier();
    }

    private boolean itemListContains(Item item){
        return items.containsKey(item.getItemIdentifier());
    }

    private void updateItemQuantityAndTotal(Item item){
        Item oldItem = items.get(item.getItemIdentifier());
        oldItem.increaseQuantity(item.getQuantity());
        items.put(oldItem.getItemIdentifier(), oldItem);
        total.updateTotal(item);
    }

    private void addItemAndUpdateTotal(Item item){
        items.put(item.getItemIdentifier(), item);
        total.updateTotal(item);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator entriesIterator = getEntries();

        while(entriesIterator.hasNext()) {
            Item item = getCurrentItem(entriesIterator);
            builder.append(item.getItemIdentifier());
            addNewLine(builder, " quantity: " + item.getQuantity().toString());
        }

        addNewLine(builder, "Total: " + total.getTotal().toString());
        addNewLine(builder, "Tax: " + total.getTotalTax());
        return builder.toString();
    }

    private Iterator getEntries(){
        Set entries = items.entrySet();
        return entries.iterator();
    }

    private Item getCurrentItem(Iterator entriesIterator){
        Map.Entry mapping = (Map.Entry) entriesIterator.next();
        return (Item) mapping.getValue();
    }

    private void addNewLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }


}
