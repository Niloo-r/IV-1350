package model;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Receipt {

    private double amountPaid;
    private double change;
    private ArrayList<ItemDTO> itemList;
    private double total;
    private LocalDateTime dateTime;
    private DateTimeFormatter time;
    private String formattedDate, storeName, adress;
    private int items;
    private ArrayList<Integer> itemQuantity;

    public Receipt(Sale sale, int items) {
        storeName = "Fruit Store";
        adress = "Seventh Street A12";
        amountPaid = sale.getAmountPaid();
        change = sale.getChange();
        itemQuantity = sale.getItemQuantityList();
        itemList = sale.getItemList();
        total = sale.getRunningTotal();
        dateTime = LocalDateTime.now();
        time = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedDate = dateTime.format(time);
        this.items = items;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getChange() {
        return change;
    }

    public ArrayList<ItemDTO> getItemList() {
        return itemList;
    }

    public int getItems() {
        return items;
    }

    public ArrayList<Integer> getItemQuantityList() {
        return this.itemQuantity;
    }

    public double getTotal() {
        return total;
    }

    public String getTime() {
        return formattedDate;
    }

    public String getName() {
        return storeName;
    }

    public String getAdress() {
        return adress;
    }


}
