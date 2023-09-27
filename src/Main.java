import View.BillView;
import View.MenuView;

import java.io.*;
import java.util.*;

public class Main {
    public static void showSelect() {
        System.out.println("Restaurant Exercise");
        System.out.println("1. Show Menu");
        System.out.println("2. Show Bill");
        System.out.println("Please choose function you'd like to do: ");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        MenuView menuView = new MenuView();
        BillView billView = new BillView();

        showSelect();
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                menuView.showMenu(scanner);
                break;
            case "2":
                System.out.println("Updating");
                break;
            default:
                System.out.println("Your choose must be from 1 to 9");
                break;
        }


//        BreakfastView breakfastView = new BreakfastView();
//        List<Menu> breakfasts = new ArrayList<>();
//        Breakfast breakfast = new Breakfast(9, "abc", "sbc", 2.5, "rtyui");
//        Breakfast breakfast2 = new Breakfast(10, "abc", "sbc", 2.5, "rtyui");
//        Breakfast breakfast3 = new Breakfast(11, "abc", "sbc", 2.5, "rtyui");
//        Breakfast breakfast4 = new Breakfast(12, "abc", "sbc", 2.5, "rtyui");
//        Menu breakfast5 = new Lunch(13, "abc", "sbc", 2, "yakjad");
//        Breakfast breakfast6 = new Breakfast(14, "abc", "sbc", 2.5, "rtyui");
//        breakfasts.add(breakfast);
//        breakfasts.add(breakfast2);
//        breakfasts.add(breakfast3);
//        breakfasts.add(breakfast4);
//        breakfasts.add(breakfast5);
//        breakfasts.add(breakfast6);

    }

}