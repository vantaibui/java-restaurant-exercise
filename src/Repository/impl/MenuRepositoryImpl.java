package repository.impl;

import entity.Menu;
import repository.MenuRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuRepositoryImpl implements MenuRepository {
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "ID,NAME,DESCRIPTION,PRICE,IMAGE,PARENT_ID,IS_DELETED";

    public List<Menu> readCSVToObject(String filename) {
        String line;
        FileReader file;
        BufferedReader bufferedReader = null;
        List<Menu> list = new ArrayList<>();
        try {
            file = new FileReader(filename);
            bufferedReader = new BufferedReader(file);
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitData = line.split(CSV_SEPARATOR);
                Menu menu = new Menu();
                menu.setId(Integer.parseInt(splitData[0]));
                menu.setName(splitData[1]);
                menu.setDescription(splitData[2]);
                menu.setPrice(Integer.parseInt(splitData[3]));
                menu.setImage(splitData[4]);
                menu.setParentId(Integer.parseInt(splitData[5]));
                menu.setDeleted(Integer.parseInt(splitData[6]) == 0 ? false : true);
                list.add(menu);
            }
            bufferedReader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Menu> findAll() {
        return null;
    }

    @Override
    public Menu findById(int id) {
        return null;
    }

    @Override
    public Menu save(Menu menu) {
        return null;
    }

    @Override
    public Menu update(Menu menu) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
