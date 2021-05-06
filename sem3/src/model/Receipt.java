package model;

import java.time.LocalDateTime;

/**
 *  Represents a receipt.
 */
public class Receipt {
    private Sale sale;
    private Payment payment;

    /**
     * a new instance is created and represents a receipt.
     */
    public Receipt(Sale sale, Payment payment){
        this.sale = sale;
        this.payment=payment;
    }

    /**
     * makes a String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        addNewLine(builder);
        appendLine(builder, "----------RECEIPT----------");
        addLocalDate(builder);
        appendLine(builder, "Items: ");
        appendLine(builder, sale.toString());
        appendLine(builder,"Total including tax: " + payment.getTotal().getTotalAndTax().toString());
        appendLine(builder, "Change: " + payment.getChange().toString());
        appendLine(builder, "------------END------------");
        return builder.toString();
    }

    private void addNewLine(StringBuilder builder){
        builder.append("\n");
    }

    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        addNewLine(builder);
    }

    private void addLocalDate(StringBuilder builder){
        LocalDateTime saleTime = LocalDateTime.now();
        appendLine(builder, "Sale time: " + saleTime.toLocalDate().toString());
    }

}
