package entity;

public class BillOrder {
    private int id;
    private int menuId;
    private int billId;
    private double menuPrice;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
