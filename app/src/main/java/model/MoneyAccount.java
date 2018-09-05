package model;

public class MoneyAccount {

    private Double amountAvailable= 12.00;
    private Double pendingAmount = 0.50;


    public Double getAmountAvailable() {
        return amountAvailable;
    }

    public Double getPendingAmount() {
        return pendingAmount;
    }

    public void setAmountAvailable(Double amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public void setPendingAmount(Double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }
}
