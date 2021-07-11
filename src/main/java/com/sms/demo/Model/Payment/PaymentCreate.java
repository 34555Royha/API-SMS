package com.sms.demo.Model.Payment;

public class PaymentCreate {
    private String InvoiceID;
    private Double Amount;
    private Double Discount;
    private Double Paid;
    private String Remain;
    public String getInvoiceID() {
        return InvoiceID;
    }
    public void setInvoiceID(String invoiceID) {
        InvoiceID = invoiceID;
    }
    public Double getAmount() {
        return Amount;
    }
    public void setAmount(Double amount) {
        Amount = amount;
    }
    public Double getDiscount() {
        return Discount;
    }
    public void setDiscount(Double discount) {
        Discount = discount;
    }
    public Double getPaid() {
        return Paid;
    }
    public void setPaid(Double paid) {
        Paid = paid;
    }
    public String getRemain() {
        return Remain;
    }
    public void setRemain(String remain) {
        Remain = remain;
    }
    public PaymentCreate(String invoiceID, Double amount, Double discount, Double paid, String remain) {
        InvoiceID = invoiceID;
        Amount = amount;
        Discount = discount;
        Paid = paid;
        Remain = remain;
    }
    @Override
    public String toString() {
        return "PaymentCreate [Amount=" + Amount + ", Discount=" + Discount + ", InvoiceID=" + InvoiceID + ", Paid="
                + Paid + ", Remain=" + Remain + "]";
    }

    
   

    
}
