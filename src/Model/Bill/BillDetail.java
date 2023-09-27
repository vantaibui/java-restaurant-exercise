package Model.Bill;

import Model.Menu.Menu;

public class BillDetail {
    private int id;
    private Menu menu;
    private int quantity;
    public BillDetail(){}
    public BillDetail(int id, Menu menu, int quantity) {
        this.id = id;
        this.menu = menu;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
