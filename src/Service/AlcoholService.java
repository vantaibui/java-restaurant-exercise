package Service;

import Model.Menu.Drink.Alcohol;
import Model.Menu.Drink.Soft;

import java.util.List;

public interface AlcoholService {
    List<Alcohol> getAll();

    Alcohol getAlcoholDetail(int id);

    List<Alcohol> save(Alcohol alcohol);

    Alcohol update(Alcohol alcohol);

    boolean delete(int id);
}
