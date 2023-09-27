package View.FoodView;

import Controller.LunchController;
import Model.Menu.Food.Lunch;
import Repository.LunchRepository;
import Repository.impl.LunchRepositoryImpl;
import Service.LunchService;
import Service.impl.LunchServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LunchView {
    String filename = "lunch.csv";
    private LunchRepository lunchRepository = new LunchRepositoryImpl(filename);
    private LunchService lunchService = new LunchServiceImpl(lunchRepository);
    private LunchController lunchController = new LunchController(lunchService);

    public void showSelectMenu() {
        System.out.println("Please choose function you'd like to do: ");
        System.out.println("1. Show all lunch menu");
        System.out.println("2. Get lunch detail");
        System.out.println("3. Add new lunch menu");
        System.out.println("4. Update a lunch menu");
        System.out.println("5. Delete a lunch menu");
    }

    public void showMenu(Scanner scanner) {
        showSelectMenu();
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                this.showAllLunchMenu();
                break;
            case "2":
                this.showLunchDetail(scanner);
                break;
            case "3":
                this.addLunchMenu(scanner);
                break;
            case "4":
                this.updateLunchMenu(scanner);
                break;
            case "5":
                this.deleteLunchMenu(scanner);
                break;
            default:
                System.out.println("Your choose must be from 1 to 5");
                break;
        }
    }

    public void showAllLunchMenu() {
        List<Lunch> lunchList = lunchController.getAllLunch();
        lunchList.forEach(System.out::println);
    }

    public void showLunchDetail(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        System.out.println(lunchController.getLunchDetail(id));
    }

    public void addLunchMenu(Scanner scanner) {
        Lunch lunch = new Lunch();
        Random random = new Random();
        lunch.setId(random.nextInt());
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        lunch.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        lunch.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        lunch.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        lunch.setImage(image);
        List<Lunch> lunchList = lunchController.save(lunch);
        if (lunchList != null) {
            System.out.println("Success");
        } else {
            System.err.println("Failed");
        }
    }

    public void updateLunchMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        Lunch lunch = lunchController.getLunchDetail(id);
        System.out.println("Detail: " + lunch);

        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        lunch.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        lunch.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        lunch.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        lunch.setImage(image);
        Lunch lunchUpdated = lunchController.update(lunch);
        if (lunchUpdated != null) {
            System.out.println("Update successfully!");
            System.out.println("Detail: " + lunchUpdated);
        } else {
            System.out.println("Update failed!");
        }
    }

    public void deleteLunchMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        boolean delete = lunchController.delete(id);
        if (delete) {
            System.out.println("Delete successfully!");
        } else {
            System.out.println("Delete failed!");
        }
    }
}
