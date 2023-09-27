package Service;

import Model.Menu.Drink.Soft;

import java.util.List;

public interface SoftService {
    List<Soft> getAll();

    Soft getSoftDetail(int id);

    List<Soft> save(Soft soft);

    Soft update(Soft soft);

    boolean delete(int id);
}
