package Repository.impl;

import Model.Menu.Food.Dinner;
import Model.Menu.Menu;
import Repository.DinnerRepository;
import Utils.FileHandler;

import java.util.List;

public class DinnerRepositoryImpl implements DinnerRepository {
    private String type = "DINNER";
    private String filename = "";

    public DinnerRepositoryImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Dinner> getAll() {
        return FileHandler.readCSVFileToObject(this.type, filename);
    }

    @Override
    public List<Dinner> save(Dinner dinner) {
        List<Menu> dinnerList = FileHandler.readCSVFileToObject(this.type, filename);
        dinnerList.add(dinner);
        try {
            FileHandler.writeObjectToCSVFile(filename, dinnerList);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }

        return FileHandler.readCSVFileToObject(this.type, filename);
    }

    @Override
    public Dinner update(Dinner dinner) {
        List<Menu> dinnerList = FileHandler.readCSVFileToObject(this.type, filename);
        Menu oldDinner = dinnerList.stream().filter(d -> dinner.getId() == d.getId()).findAny().orElse(null);
        if (oldDinner != null) {
            dinnerList.set(oldDinner.getId(), dinner);
            FileHandler.writeObjectToCSVFile(filename, dinnerList);
            return dinner;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        List<Menu> dinnerList = FileHandler.readCSVFileToObject(this.type, filename);
        Menu dinner = dinnerList.stream().filter(d -> id == d.getId()).findAny().orElse(null);
        if (dinner != null) {
            dinnerList.remove(dinner);
            FileHandler.writeObjectToCSVFile(filename, dinnerList);
            return true;
        }
        return false;
    }

    @Override
    public Dinner findById(int id) {
        List<Dinner> dinnerList = FileHandler.readCSVFileToObject(this.type, filename);
        return dinnerList.stream().filter(dinner -> id == dinner.getId()).findAny().orElse(null);
    }

    @Override
    public Dinner findByName(String name) {
        List<Dinner> dinnerList = FileHandler.readCSVFileToObject(this.type, filename);
        return dinnerList.stream().filter(dinner -> dinner.getName().compareTo(name) != -1).findAny().orElse(null);
    }
}
