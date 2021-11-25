package view;

import se.kth.model.RegisterObserver;

/**
 * Prints the total income to a log. The 500 represents income from a previous
 * sale.
 */
public class TotalRevenueFileOutput implements RegisterObserver {
    private double totalRevenue = 500;
    private FileLogger logger;

    /**
     * Sets the logger for the file.
     *
     * @param logger
     */
    public void setLogger(FileLogger logger) {
        this.logger = logger;
    }

    /**
     * Writes a String to the log.
     *
     * @param cashAmount The increase in total income.
     */
    @Override
    public void totalRevenue(double cashAmount) {
        totalRevenue = totalRevenue + cashAmount;
        logger.log("New total income is: " + String.valueOf(totalRevenue) + "\n");

    }
}
