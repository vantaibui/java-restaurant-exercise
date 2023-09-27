package Service;

import Model.Menu.Food.Lunch;

import java.util.List;

public interface LunchService {
    List<Lunch> getAll();

    Lunch getLunchDetail(int id);

    List<Lunch> save(Lunch lunch);

    Lunch update(Lunch lunch);

    boolean delete(int id);
}
