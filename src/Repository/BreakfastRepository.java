package Repository;

import Model.Menu.Food.Breakfast;

import java.io.FileNotFoundException;
import java.util.List;

public interface BreakfastRepository {
    List<Breakfast> getAll();

    List<Breakfast> saveManyBreakfast(List<Breakfast> breakfastList);

    List<Breakfast> save(Breakfast breakfast);

    Breakfast update(Breakfast breakfast);

    boolean delete(int id);

    Breakfast findById(int id);

    Breakfast findByName(String name);
}
