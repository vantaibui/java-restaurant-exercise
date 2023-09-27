package Repository.impl;

import Model.Menu.Drink.Alcohol;
import Model.Menu.Menu;
import Repository.AlcoholRepository;
import Utils.FileHandler;

import java.util.List;

public class AlcoholRepositoryImpl implements AlcoholRepository {
    private String filename = "";
    private String type = "ALCOHOL";

    public AlcoholRepositoryImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Alcohol> getAll() {
        return FileHandler.readCSVFileToObject(this.type, this.filename);
    }

    @Override
    public List<Alcohol> save(Alcohol alcohol) {
        List<Menu> alcoholList = FileHandler.readCSVFileToObject(this.type, this.filename);
        alcoholList.add(alcohol);
        try {
            FileHandler.writeObjectToCSVFile(this.filename, alcoholList);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }

        return FileHandler.readCSVFileToObject(this.type, this.filename);
    }

    @Override
    public Alcohol update(Alcohol alcohol) {
        List<Menu> alcoholList = FileHandler.readCSVFileToObject(this.type, this.filename);
        Menu oldAlcohol = alcoholList.stream().filter(d -> alcohol.getId() == d.getId()).findAny().orElse(null);
        if (oldAlcohol != null) {
            alcoholList.set(oldAlcohol.getId(), alcohol);
            FileHandler.writeObjectToCSVFile(this.filename, alcoholList);
            return alcohol;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        List<Menu> alcoholList = FileHandler.readCSVFileToObject(this.type, this.filename);
        Menu alcohol = alcoholList.stream().filter(l -> id == l.getId()).findAny().orElse(null);
        if (alcohol != null) {
            alcoholList.remove(alcohol);
            FileHandler.writeObjectToCSVFile(this.filename, alcoholList);
            return true;
        }
        return false;
    }

    @Override
    public Alcohol findById(int id) {
        List<Alcohol> alcoholList = FileHandler.readCSVFileToObject(this.type, this.filename);
        return alcoholList.stream().filter(alcohol -> id == alcohol.getId()).findAny().orElse(null);
    }

    @Override
    public Alcohol findByName(String name) {
        List<Alcohol> alcoholList = FileHandler.readCSVFileToObject(this.type, this.filename);
        return alcoholList.stream().filter(alcohol -> alcohol.getName().compareTo(name) != -1).findAny().orElse(null);
    }
}
