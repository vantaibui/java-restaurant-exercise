package Repository;

import Model.Menu.Food.Lunch;

import java.util.List;

public interface LunchRepository {
    List<Lunch> getAll();

    List<Lunch> save(Lunch lunch);

    Lunch update(Lunch lunch);

    boolean delete(int id);

    Lunch findById(int id);

    Lunch findByName(String name);
}
