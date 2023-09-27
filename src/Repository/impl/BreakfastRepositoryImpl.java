package Repository.impl;

import Model.Menu.Food.Breakfast;
import Repository.BreakfastRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BreakfastRepositoryImpl implements BreakfastRepository {
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "id,name,description,amount,image";
    private String filename;

    public BreakfastRepositoryImpl(String filename) {
        this.filename = filename;
    }

    public static Breakfast convertToBreakfast(String[] breakfast) {
        int id = Integer.parseInt(breakfast[0]);
        String name = breakfast[1];
        String description = breakfast[2];
        double amount = Double.parseDouble(breakfast[3]);
        String image = "/image";

        return new Breakfast(id, name, description, amount, image);
    }

    public static List<Breakfast> readFile(String pathname) {
        String line;
        FileReader file;
        BufferedReader bufferedReader;
        List<Breakfast> list = new ArrayList<>();
        try {
            file = new FileReader(pathname);
            bufferedReader = new BufferedReader(file);
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitData = line.split(CSV_SEPARATOR);
                Breakfast breakfast = convertToBreakfast(splitData);
                list.add(breakfast);
            }
            bufferedReader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void writeFile(String pathname, List<Breakfast> breakfastList) throws FileNotFoundException {
        Random random = new Random();
        File file = new File(pathname);
        if (!file.exists()) {
            System.err.println("File does not exist");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        try {
            bufferedWriter.append(FILE_HEADER);
            bufferedWriter.newLine();
            for (int i = 0; i < breakfastList.size() - 1; i++) {
                bufferedWriter.append(breakfastList.get(i).getId() <= 0 ? String.valueOf(random.nextInt()) : String.valueOf(breakfastList.get(i).getId()));
                bufferedWriter.append(CSV_SEPARATOR);
                bufferedWriter.append(breakfastList.get(i).getName());
                bufferedWriter.append(CSV_SEPARATOR);
                bufferedWriter.append(breakfastList.get(i).getDescription());
                bufferedWriter.append(CSV_SEPARATOR);
                bufferedWriter.append(breakfastList.get(i).getAmount() <= 0 ? String.valueOf(random.nextDouble()) : String.valueOf(breakfastList.get(i).getAmount()));
                bufferedWriter.append(CSV_SEPARATOR);
                bufferedWriter.append(breakfastList.get(i).getImage() != null ? "/image" : breakfastList.get(i).getImage());
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

    @Override
    public List<Breakfast> getAll() {
        return readFile(filename);
    }

    @Override
    public List<Breakfast> saveManyBreakfast(List<Breakfast> breakfastList) {
        try {
            writeFile(filename, breakfastList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return readFile(filename);
    }

    @Override
    public List<Breakfast> save(Breakfast breakfast) {
        List<Breakfast> breakfastList = readFile(filename);
        breakfastList.add(breakfast);
        try {
            writeFile(filename, breakfastList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return breakfastList;
    }

    @Override
    public Breakfast update(Breakfast breakfast) {
        List<Breakfast> breakfastList = readFile(filename);
        Breakfast oldBreakfast = breakfastList.stream().filter((bf) -> breakfast.getId() == bf.getId()).findAny().orElse(null);
        if (oldBreakfast != null) {
            breakfastList.set(oldBreakfast.getId(), breakfast);
            try {
                writeFile(filename, breakfastList);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return breakfast;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        List<Breakfast> breakfastList = readFile(filename);
        Breakfast breakfast = breakfastList.stream().filter((bf) -> bf.getId() == id).findAny().orElse(null);
        if (breakfast != null) {
            breakfastList.remove(breakfast);
            try {
                writeFile(filename, breakfastList);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }

    @Override
    public Breakfast findById(int id) {
        List<Breakfast> breakfastList = readFile(filename);
        return breakfastList.stream().filter(bf -> bf.getId() == id).findAny().orElse(null);
    }

    @Override
    public Breakfast findByName(String name) {
        List<Breakfast> breakfastList = readFile(filename);
        return breakfastList.stream().filter(bf -> bf.getName().compareTo(name) != -1).findAny().orElse(null);
    }
}
