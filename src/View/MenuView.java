package View;

import Controller.MenuController;
import Model.Menu.Menu;
import Repository.*;
import Repository.impl.*;
import Service.MenuService;
import Service.impl.MenuServiceImpl;
import View.DrinkView.AlcoholView;
import View.DrinkView.SoftView;
import View.FoodView.BreakfastView;
import View.FoodView.DinnerView;
import View.FoodView.LunchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    String breakfastFilename = "breakfast.csv";
    private BreakfastRepository breakfastRepository = new BreakfastRepositoryImpl(breakfastFilename);
    String lunchFilename = "lunch.csv";
    private LunchRepository lunchRepository = new LunchRepositoryImpl(lunchFilename);
    String dinnerFilename = "dinner.csv";
    private DinnerRepository dinnerRepository = new DinnerRepositoryImpl(dinnerFilename);
    String alcoholFilename = "alcohol.csv";
    private AlcoholRepository alcoholRepository = new AlcoholRepositoryImpl(alcoholFilename);
    String softFilename = "soft.csv";
    private SoftRepository softRepository = new SoftRepositoryImpl(softFilename);
    private MenuService menuService = new MenuServiceImpl(breakfastRepository, lunchRepository, dinnerRepository, alcoholRepository, softRepository);
    private MenuController menuController = new MenuController(menuService);

    private BreakfastView breakfastView = new BreakfastView();
    private LunchView lunchView = new LunchView();
    private DinnerView dinnerView = new DinnerView();
    private AlcoholView alcoholView = new AlcoholView();
    private SoftView softView = new SoftView();

    public static void showSelect() {
        System.out.println("Please choose function you'd like to do: ");
        System.out.println("1. Show all Menu");
        System.out.println("2. Show Breakfast Menu");
        System.out.println("3. Show Lunch Menu");
        System.out.println("4. Show Dinner Menu");
        System.out.println("5. Show Alcohol Drink Menu");
        System.out.println("6. Show Soft Drink Menu");
    }

    public void showMenu(Scanner scanner) {
        showSelect();
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                this.showAllMenu();
                break;
            case "2":
                breakfastView.showMenu(scanner);
                break;
            case "3":
                lunchView.showMenu(scanner);
                break;
            case "4":
                dinnerView.showMenu(scanner);
                break;
            case "5":
                alcoholView.showMenu(scanner);
                break;
            case "6":
                softView.showMenu(scanner);
                break;
            default:
                System.out.println("Your choose must be from 1 to 6");
                break;
        }
    }

    public void showAllMenu() {
        List<Menu> menuList = menuController.getAllMenu();
        menuList.forEach(System.out::println);
    }
}
