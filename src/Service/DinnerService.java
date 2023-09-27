package Service;

import Model.Menu.Food.Dinner;

import java.util.List;

public interface DinnerService {
    List<Dinner> getAll();

    Dinner getDinnerDetail(int id);

    List<Dinner> save(Dinner dinner);

    Dinner update(Dinner dinner);

    boolean delete(int id);
}
