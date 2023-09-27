package Model.Menu.Food;

import Model.Menu.Menu;

import java.util.TimeZone;

public class Food extends Menu {
    private TimeZone servedTime;

    public Food() {
    }

    public Food(int id, String name, String description, double amount, String image) {
        super(id, name, description, amount, image);
    }

    public TimeZone getServedTime() {
        return servedTime;
    }

    public void setServedTime(TimeZone servedTime) {
        this.servedTime = servedTime;
    }
}
