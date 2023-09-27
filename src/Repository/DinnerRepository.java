package Repository;

import Model.Menu.Food.Dinner;

import java.util.List;

public interface DinnerRepository {
    List<Dinner> getAll();

    List<Dinner> save(Dinner dinner);

    Dinner update(Dinner dinner);

    boolean delete(int id);

    Dinner findById(int id);

    Dinner findByName(String name);
}
