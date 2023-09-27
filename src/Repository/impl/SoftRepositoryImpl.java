package Repository.impl;

import Model.Menu.Drink.Soft;
import Model.Menu.Menu;
import Repository.SoftRepository;
import Utils.FileHandler;

import java.util.List;

public class SoftRepositoryImpl implements SoftRepository {
    private String type = "SOFT";
    private String filename = "";

    public SoftRepositoryImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Soft> getAll() {
        return FileHandler.readCSVFileToObject(this.type, this.filename);
    }

    @Override
    public List<Soft> save(Soft soft) {
        List<Menu> softList = FileHandler.readCSVFileToObject(this.type, this.filename);
        softList.add(soft);
        try {
            FileHandler.writeObjectToCSVFile(this.filename, softList);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }

        return FileHandler.readCSVFileToObject(this.type, this.filename);
    }

    @Override
    public Soft update(Soft soft) {
        List<Menu> softList = FileHandler.readCSVFileToObject(this.type, this.filename);
        Menu oldSoft = softList.stream().filter(d -> soft.getId() == d.getId()).findAny().orElse(null);
        if (oldSoft != null) {
            softList.set(oldSoft.getId(), soft);
            FileHandler.writeObjectToCSVFile(this.filename, softList);
            return soft;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        List<Menu> softList = FileHandler.readCSVFileToObject(this.type, this.filename);
        Menu soft = softList.stream().filter(l -> id == l.getId()).findAny().orElse(null);
        if (soft != null) {
            softList.remove(soft);
            FileHandler.writeObjectToCSVFile(this.filename, softList);
            return true;
        }
        return false;
    }

    @Override
    public Soft findById(int id) {
        List<Soft> softList = FileHandler.readCSVFileToObject(this.type, this.filename);
        return softList.stream().filter(soft -> id == soft.getId()).findAny().orElse(null);
    }

    @Override
    public Soft findByName(String name) {
        List<Soft> softList = FileHandler.readCSVFileToObject(this.type, this.filename);
        return softList.stream().filter(soft -> soft.getName().compareTo(name) != -1).findAny().orElse(null);
    }
}
