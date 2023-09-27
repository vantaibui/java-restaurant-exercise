package Model.Bill;

import java.util.Date;
import java.util.List;

public class Bill {
    private int id;
    private List<BillDetail> billDetails;
    private Date orderedTime;
    private double subTotal;
    private double tax;
    private double totalAmount;

    public Bill() {
    }

    public Bill(int id, List<BillDetail> billDetails, Date orderedTime, double subTotal, double tax, double totalAmount) {
        this.id = id;
        this.billDetails = billDetails;
        this.orderedTime = orderedTime;
        this.subTotal = subTotal;
        this.tax = tax;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetail(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    public Date getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Date orderedTime) {
        this.orderedTime = orderedTime;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        double subTotalMenu = 0;
        for (BillDetail billDetail : this.billDetails) {
            subTotalMenu += billDetail.getMenu().getAmount() * billDetail.getQuantity();
        }
        this.subTotal = subTotalMenu;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = this.getSubTotal() * this.getTax();
    }
}
