package View.FoodView;

import Controller.BreakfastController;
import Model.Menu.Food.Breakfast;
import Repository.BreakfastRepository;
import Repository.impl.BreakfastRepositoryImpl;
import Service.BreakfastService;
import Service.impl.BreakfastServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BreakfastView {
    String filename = "breakfast.csv";
    private BreakfastRepository breakfastRepository = new BreakfastRepositoryImpl(filename);
    private BreakfastService breakfastService = new BreakfastServiceImpl(breakfastRepository);
    private BreakfastController breakfastController = new BreakfastController(breakfastService);

    public void showSelectMenu() {
        System.out.println("Please choose function you'd like to do: ");
        System.out.println("1. Show all breakfast menu");
        System.out.println("2. Get breakfast detail");
        System.out.println("3. Add new breakfast menu");
        System.out.println("4. Update a breakfast menu");
        System.out.println("5. Delete a breakfast menu");
    }

    public void showMenu(Scanner scanner) {
        this.showSelectMenu();
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                this.showAllBreakfasts();
                break;
            case "2":
                this.showBreakfastDetail(scanner);
                break;
            case "3":
                this.addBreakfastMenu(scanner);
                break;
            case "4":
                this.updateBreakfastMenu(scanner);
                break;
            case "5":
                this.deleteBreakfastMenu(scanner);
                break;
            default:
                System.out.println("Your choose must be from 1 to 5");
                break;
        }
    }

    public void showAllBreakfasts() {
        List<Breakfast> breakfastList = breakfastController.getAllBreakfast();
        breakfastList.forEach((System.out::println));
    }

    public void showBreakfastDetail(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        System.out.println(breakfastController.getBreakfastDetail(id));
    }

    public void saveManyBreakfast(List<Breakfast> breakfastList) {
        breakfastController.saveManyBreakfast(breakfastList);
    }

    public void addBreakfastMenu(Scanner scanner) {
        Breakfast breakfast = new Breakfast();
        Random random = new Random();
        breakfast.setId(random.nextInt());
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        breakfast.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        breakfast.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        breakfast.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        breakfast.setImage(image);
        List<Breakfast> breakfastList = breakfastController.save(breakfast);
        if (breakfastList != null) {
            breakfastList.forEach(System.out::println);
            System.out.println("Success");
        } else {
            System.err.println("Failed");
        }
    }

    public void updateBreakfastMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        Breakfast breakfast = breakfastController.getBreakfastDetail(id);
        System.out.println("Detail: " + breakfast);

        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        breakfast.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        breakfast.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        breakfast.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        breakfast.setImage(image);
        Breakfast breakfastUpdated = breakfastController.update(breakfast);
        if (breakfastUpdated != null) {
            System.out.println("Update successfully!");
            System.out.println("Detail: " + breakfastUpdated);
        } else {
            System.out.println("Update failed!");
        }
    }

    public void deleteBreakfastMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        boolean delete = breakfastController.delete(id);
        if (delete) {
            System.out.println("Delete successfully!");
        } else {
            System.out.println("Delete failed!");
        }
    }

}
