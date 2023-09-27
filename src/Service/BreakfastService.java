package Service;

import Model.Menu.Food.Breakfast;

import java.io.FileNotFoundException;
import java.util.List;

public interface BreakfastService {
    List<Breakfast> getAll();

    Breakfast getBreakfastDetail(int id);

    List<Breakfast> saveManyBreakfast(List<Breakfast> breakfastList);

    List<Breakfast> save(Breakfast breakfast);

    Breakfast update(Breakfast breakfast);

    boolean delete(int id);

}
