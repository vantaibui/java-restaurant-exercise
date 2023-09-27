package View.DrinkView;

import Controller.DrinkController.SoftController;
import Model.Menu.Drink.Soft;
import Repository.SoftRepository;
import Repository.impl.SoftRepositoryImpl;
import Service.SoftService;
import Service.impl.SoftServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SoftView {
    String filename = "soft.csv";
    private SoftRepository softRepository = new SoftRepositoryImpl(filename);
    private SoftService softService = new SoftServiceImpl(softRepository);
    private SoftController softController = new SoftController(softService);

    public void showSelectMenu() {
        System.out.println("Please choose function you'd like to do: ");
        System.out.println("1. Show all soft menu");
        System.out.println("2. Get soft detail");
        System.out.println("3. Add new soft menu");
        System.out.println("4. Update a soft menu");
        System.out.println("5. Delete a soft menu");
    }

    public void showMenu(Scanner scanner) {
        showSelectMenu();
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                this.showAllSoftMenu();
                break;
            case "2":
                this.showSoftDetail(scanner);
                break;
            case "3":
                this.addSoftMenu(scanner);
                break;
            case "4":
                this.updateSoftMenu(scanner);
                break;
            case "5":
                this.deleteSoftMenu(scanner);
                break;
            default:
                System.out.println("Your choose must be from 1 to 5");
                break;
        }
    }

    public void showAllSoftMenu() {
        List<Soft> softList = softController.getAllSoft();
        softList.forEach(System.out::println);
    }

    public void showSoftDetail(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        System.out.println(softController.getSoftDetail(id));
    }

    public void addSoftMenu(Scanner scanner) {
        Soft soft = new Soft();
        Random random = new Random();
        soft.setId(random.nextInt());
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        soft.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        soft.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        soft.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        soft.setImage(image);
        List<Soft> softList = softController.save(soft);
        if (softList != null) {
            System.out.println("Success");
        } else {
            System.err.println("Failed");
        }
    }

    public void updateSoftMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        Soft soft = softController.getSoftDetail(id);
        System.out.println("Detail: " + soft);

        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        soft.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        soft.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        soft.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        soft.setImage(image);
        Soft softUpdated = softController.update(soft);
        if (softUpdated != null) {
            System.out.println("Update successfully!");
            System.out.println("Detail: " + softUpdated);
        } else {
            System.out.println("Update failed!");
        }
    }

    public void deleteSoftMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        boolean delete = softController.delete(id);
        if (delete) {
            System.out.println("Delete successfully!");
        } else {
            System.out.println("Delete failed!");
        }
    }
}
