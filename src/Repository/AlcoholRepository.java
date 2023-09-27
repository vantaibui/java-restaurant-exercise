package Repository;

import Model.Menu.Drink.Alcohol;

import java.util.List;

public interface AlcoholRepository {
    List<Alcohol> getAll();

    List<Alcohol> save(Alcohol alcohol);

    Alcohol update(Alcohol alcohol);

    boolean delete(int id);

    Alcohol findById(int id);

    Alcohol findByName(String name);
}
