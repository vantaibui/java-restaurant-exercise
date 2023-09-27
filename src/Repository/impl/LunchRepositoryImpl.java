package Repository.impl;

import Model.Menu.Food.Lunch;
import Model.Menu.Menu;
import Repository.LunchRepository;
import Utils.FileHandler;

import java.util.List;

public class LunchRepositoryImpl implements LunchRepository {
    private String type = "LUNCH";
    private String filename = "";

    public LunchRepositoryImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Lunch> getAll() {
        return FileHandler.readCSVFileToObject(this.type, this.filename);
    }

    @Override
    public List<Lunch> save(Lunch lunch) {
        List<Menu> lunchList = FileHandler.readCSVFileToObject(this.type, this.filename);
        lunchList.add(lunch);
        try {
            FileHandler.writeObjectToCSVFile(this.filename, lunchList);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }

        return FileHandler.readCSVFileToObject(this.type, this.filename);
    }

    @Override
    public Lunch update(Lunch lunch) {
        List<Menu> lunchList = FileHandler.readCSVFileToObject(this.type, this.filename);
        Menu oldLunch = lunchList.stream().filter(d -> lunch.getId() == d.getId()).findAny().orElse(null);
        if (oldLunch != null) {
            lunchList.set(oldLunch.getId(), lunch);
            FileHandler.writeObjectToCSVFile(this.filename, lunchList);
            return lunch;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        List<Menu> lunchList = FileHandler.readCSVFileToObject(this.type, this.filename);
        Menu lunch = lunchList.stream().filter(l -> id == l.getId()).findAny().orElse(null);
        if (lunch != null) {
            lunchList.remove(lunch);
            FileHandler.writeObjectToCSVFile(this.filename, lunchList);
            return true;
        }
        return false;
    }

    @Override
    public Lunch findById(int id) {
        List<Lunch> lunchList = FileHandler.readCSVFileToObject(this.type, this.filename);
        return lunchList.stream().filter(lunch -> id == lunch.getId()).findAny().orElse(null);
    }

    @Override
    public Lunch findByName(String name) {
        List<Lunch> lunchList = FileHandler.readCSVFileToObject(this.type, this.filename);
        return lunchList.stream().filter(lunch -> lunch.getName().compareTo(name) != -1).findAny().orElse(null);
    }
}
