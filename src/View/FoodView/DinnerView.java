package View.FoodView;

import Controller.DinnerController;
import Model.Menu.Food.Dinner;
import Repository.DinnerRepository;
import Repository.impl.DinnerRepositoryImpl;
import Service.DinnerService;
import Service.impl.DinnerServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DinnerView {
    String filename = "dinner.csv";
    private DinnerRepository dinnerRepository = new DinnerRepositoryImpl(filename);
    private DinnerService dinnerService = new DinnerServiceImpl(dinnerRepository);
    private DinnerController dinnerController = new DinnerController(dinnerService);

    public void showSelectMenu() {
        System.out.println("Please choose function you'd like to do: ");
        System.out.println("1. Show all dinner menu");
        System.out.println("2. Get dinner detail");
        System.out.println("3. Add new dinner menu");
        System.out.println("4. Update a dinner menu");
        System.out.println("5. Delete a dinner menu");
    }

    public void showMenu(Scanner scanner) {
        showSelectMenu();
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                this.showAllDinnerMenu();
                break;
            case "2":
                this.showDinnerDetail(scanner);
                break;
            case "3":
                this.addDinnerMenu(scanner);
                break;
            case "4":
                this.updateDinnerMenu(scanner);
                break;
            case "5":
                this.deleteDinnerMenu(scanner);
                break;
            default:
                System.out.println("Your choose must be from 1 to 5");
                break;
        }
    }

    public void showAllDinnerMenu() {
        List<Dinner> dinnerList = dinnerController.getAllDinner();
        dinnerList.forEach(System.out::println);
    }

    public void showDinnerDetail(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        System.out.println(dinnerController.getDinnerDetail(id));
    }

    public void addDinnerMenu(Scanner scanner) {
        Dinner dinner = new Dinner();
        Random random = new Random();
        dinner.setId(random.nextInt());
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        dinner.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        dinner.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        dinner.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        dinner.setImage(image);
        List<Dinner> dinnerList = dinnerController.save(dinner);
        if (dinnerList != null) {
            System.out.println("Success");
        } else {
            System.err.println("Failed");
        }
    }

    public void updateDinnerMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        Dinner dinner = dinnerController.getDinnerDetail(id);
        System.out.println("Detail: " + dinner);

        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        dinner.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        dinner.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        dinner.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        dinner.setImage(image);
        Dinner dinnerUpdated = dinnerController.update(dinner);
        if (dinnerUpdated != null) {
            System.out.println("Update successfully!");
            System.out.println("Detail: " + dinnerUpdated);
        } else {
            System.out.println("Update failed!");
        }
    }

    public void deleteDinnerMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        boolean delete = dinnerController.delete(id);
        if (delete) {
            System.out.println("Delete successfully!");
        } else {
            System.out.println("Delete failed!");
        }
    }
}
