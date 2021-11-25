package view;

import model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
    private double totalRevenue = 0;

    /**
     * Empty instructor.
     * starts with value 0
     */
    public TotalRevenueView() {
        this.totalRevenue = 0;
    }

    /**
     * The total revenue will be increased.
     * @param paidAmount - is the paid amount.
     */
    public void newPayment (double paidAmount){
        totalRevenue = totalRevenue + paidAmount;
        showOnDisplay();
    }

    /**
     * The total revenue is printed out.
     */

    private void showOnDisplay() {

        System.out.println("Totalt betalt belopp från alla sales: " + Math.round(totalRevenue));

    }

    /**
     * is used to check if the class works as it is supposed to.
     * @return totalRevenue - will check if the class works properly.
     */

    public double getTotalRevenue(){
        return totalRevenue;
    }


}

