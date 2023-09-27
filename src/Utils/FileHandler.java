package Utils;

import Model.Menu.Drink.Alcohol;
import Model.Menu.Drink.Soft;
import Model.Menu.Food.Breakfast;
import Model.Menu.Food.Dinner;
import Model.Menu.Food.Lunch;
import Model.Menu.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileHandler {
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "id,name,description,amount,image";

    public static <T> T convertToObject(String type, String[] metadata) {
        T t;
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        String description = metadata[2];
        double amount = Double.parseDouble(metadata[3]);
        String image = metadata[4];

        switch (type) {
            case "BREAKFAST": {
                t = (T) new Breakfast(id, name, description, amount, image);
                break;
            }
            case "LUNCH": {
                t = (T) new Lunch(id, name, description, amount, image);
                break;
            }
            case "DINNER": {
                t = (T) new Dinner(id, name, description, amount, image);
                break;
            }
            case "ALCOHOL": {
                t = (T) new Alcohol(id, name, description, amount, image);
                break;
            }
            case "SOFT": {
                t = (T) new Soft(id, name, description, amount, image);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return t;
    }

    public static <T> List<T> readCSVFileToObject(String type, String filename) {
        String line;
        FileReader file;
        BufferedReader bufferedReader = null;
        List<T> list = new ArrayList<T>();
        try {
            file = new FileReader(filename);
            bufferedReader = new BufferedReader(file);
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitData = line.split(CSV_SEPARATOR);
                T t = (T) convertToObject(type, splitData);
                list.add(t);
            }
            bufferedReader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public static void writeObjectToCSVFile(String filename, List<Menu> menus) {
        Random random = new Random();
        File file = new File(filename);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        try {
            bufferedWriter.append(FILE_HEADER);
            bufferedWriter.newLine();
            for (int i = 0; i < menus.size() - 1; i++) {
                bufferedWriter.append(menus.get(i).getId() <= 0 ? String.valueOf(random.nextInt()) : String.valueOf(menus.get(i).getId()));
                bufferedWriter.append(CSV_SEPARATOR);
                bufferedWriter.append(menus.get(i).getName());
                bufferedWriter.append(CSV_SEPARATOR);
                bufferedWriter.append(menus.get(i).getDescription());
                bufferedWriter.append(CSV_SEPARATOR);
                bufferedWriter.append(menus.get(i).getAmount() <= 0 ? String.valueOf(random.nextDouble()) : String.valueOf(menus.get(i).getAmount()));
                bufferedWriter.append(CSV_SEPARATOR);
                bufferedWriter.append(menus.get(i).getImage() != null ? "/image" : menus.get(i).getImage());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
