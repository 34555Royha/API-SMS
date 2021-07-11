package com.sms.demo.Model.Payment;

public class Payment {
    private String Id;
    private String InvoiceID;
    private Float Amount;
    private Float Discount;
    private Float Paid;
    private String Remain;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        InvoiceID = invoiceID;
    }

    public Float getAmount() {
        return Amount;
    }

    public void setAmount(Float amount) {
        Amount = amount;
    }

    public Float getDiscound() {
        return Discount;
    }

    public void setDiscound(Float discound) {
        Discount = discound;
    }

    public Float getPaid() {
        return Paid;
    }

    public void setPaid(Float paid) {
        Paid = paid;
    }

    public String getRemain() {
        return Remain;
    }

    public void setRemain(String remain) {
        Remain = remain;
    }

    public Payment(String id, String invoiceID, Float amount, Float discound, Float paid, String remain) {
        Id = id;
        InvoiceID = invoiceID;
        Amount = amount;
        Discount = discound;
        Paid = paid;
        Remain = remain;
    }

    @Override
    public String toString() {
        return "Payment [Amount=" + Amount + ", Discound=" + Discount + ", Id=" + Id + ", InvoiceID=" + InvoiceID
                + ", Paid=" + Paid + ", Remain=" + Remain + "]";
    }

    public Payment() {
    }

}
