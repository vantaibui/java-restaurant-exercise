package Model.Menu;

public abstract class Menu implements Comparable<Menu> {
    private int id;
    private String name;
    private String description;
    private double amount;
    private String image;

    public Menu() {
    }

    public Menu(int id, String name, String description, double amount, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", image='" + image + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int compareTo(Menu menu) {
        return this.name.compareTo(menu.name);
    }
}
