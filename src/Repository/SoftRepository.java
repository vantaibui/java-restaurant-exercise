package Repository;

import Model.Menu.Drink.Soft;

import java.util.List;

public interface SoftRepository {
    List<Soft> getAll();

    List<Soft> save(Soft soft);

    Soft update(Soft soft);

    boolean delete(int id);

    Soft findById(int id);

    Soft findByName(String name);
}
