package dto;

public class BillOrderDTO {
    private int id;
    private MenuDTO menu;
    private double price;
    private int quantity;

    public BillOrderDTO() {
    }

    public BillOrderDTO(int id, MenuDTO menu, double price, int quantity) {
        this.id = id;
        this.menu = menu;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuDTO getMenu() {
        return menu;
    }

    public void setMenu(MenuDTO menu) {
        this.menu = menu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BillOrderDTO{" + "id=" + id + ", menu=" + menu + ", price=" + price + ", quantity=" + quantity + '}';
    }
}
