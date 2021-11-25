package view;

import model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
    private double totalRevenue = 0;

    /**
     * The start value is 0.
     */
    public TotalRevenueView() {
        this.totalRevenue = 0;
    }

    /**
     * Total revenue will be increased.
     * @param paidAmount - is the paid amount.
     */
    public void newPayment (double paidAmount){
        totalRevenue = totalRevenue + paidAmount;
        showOnDisplay();
    }

    /**
     * The total amount is printed.
     */

    private void showOnDisplay() {

        System.out.println("The total paid amount is " + Math.round(totalRevenue));

    }

    /**
     * This is used to see if the class works as it should.
     * @return totalRevenue - to check if class works properly.
     */

    public double getTotalRevenue(){
        return totalRevenue;
    }


}
