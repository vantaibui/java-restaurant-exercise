import repository.MenuRepository;
import repository.impl.MenuRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void showSelect() {
        System.out.println("Restaurant Exercise");
        System.out.println("1. Show Menu");
        System.out.println("2. Show Bill");
        System.out.println("Please choose function you'd like to do: ");
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
//
//        showSelect();
//        String choose = scanner.nextLine();
//        switch (choose) {
//            case "1":
//                System.out.println("Menu");
//                break;
//            case "2":
//                System.out.println("Bill");
//                break;
//            default:
//                System.out.println("Your choose must be from 1 to 9");
//                break;
//        }

        MenuRepositoryImpl menuRepository = new MenuRepositoryImpl();
        menuRepository.readCSVToObject("menu.csv");

    }

}