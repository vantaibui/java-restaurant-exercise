package View.DrinkView;

import Controller.DrinkController.AlcoholController;
import Model.Menu.Drink.Alcohol;
import Repository.AlcoholRepository;
import Repository.impl.AlcoholRepositoryImpl;
import Service.AlcoholService;
import Service.impl.AlcoholServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AlcoholView {

    String filename = "alcohol.csv";
    private AlcoholRepository alcoholRepository = new AlcoholRepositoryImpl(filename);
    private AlcoholService alcoholService = new AlcoholServiceImpl(alcoholRepository);
    private AlcoholController alcoholController = new AlcoholController(alcoholService);

    public void showSelectMenu() {
        System.out.println("Please choose function you'd like to do: ");
        System.out.println("1. Show all alcohol menu");
        System.out.println("2. Get alcohol detail");
        System.out.println("3. Add new alcohol menu");
        System.out.println("4. Update a alcohol menu");
        System.out.println("5. Delete a alcohol menu");
    }

    public void showMenu(Scanner scanner) {
        showSelectMenu();
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                this.showAllAlcoholMenu();
                break;
            case "2":
                this.showAlcoholDetail(scanner);
                break;
            case "3":
                this.addAlcoholMenu(scanner);
                break;
            case "4":
                this.updateAlcoholMenu(scanner);
                break;
            case "5":
                this.deleteAlcoholMenu(scanner);
                break;
            default:
                System.out.println("Your choose must be from 1 to 5");
                break;
        }
    }

    public void showAllAlcoholMenu() {
        List<Alcohol> alcoholList = alcoholController.getAllAlcohol();
        alcoholList.forEach(System.out::println);
    }

    public void showAlcoholDetail(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        System.out.println(alcoholController.getAlcoholDetail(id));
    }

    public void addAlcoholMenu(Scanner scanner) {
        Alcohol alcohol = new Alcohol();
        Random random = new Random();
        alcohol.setId(random.nextInt());
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        alcohol.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        alcohol.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        alcohol.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        alcohol.setImage(image);
        List<Alcohol> alcoholList = alcoholController.save(alcohol);
        if (alcoholList != null) {
            System.out.println("Success");
        } else {
            System.err.println("Failed");
        }
    }

    public void updateAlcoholMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        Alcohol alcohol = alcoholController.getAlcoholDetail(id);
        System.out.println("Detail: " + alcohol);

        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        alcohol.setName(name);
        System.out.println("Please enter description: ");
        String desc = scanner.nextLine();
        alcohol.setDescription(desc);
        System.out.println("Please enter amount: ");
        double amount = scanner.nextDouble();
        alcohol.setAmount(amount);
        System.out.println("Please enter image: ");
        String image = scanner.nextLine();
        alcohol.setImage(image);
        Alcohol alcoholUpdated = alcoholController.update(alcohol);
        if (alcoholUpdated != null) {
            System.out.println("Update successfully!");
            System.out.println("Detail: " + alcoholUpdated);
        } else {
            System.out.println("Update failed!");
        }
    }

    public void deleteAlcoholMenu(Scanner scanner) {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        boolean delete = alcoholController.delete(id);
        if (delete) {
            System.out.println("Delete successfully!");
        } else {
            System.out.println("Delete failed!");
        }
    }
}
