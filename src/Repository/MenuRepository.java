package repository;

import entity.Menu;

import java.util.List;

public interface MenuRepository {
    List<Menu> findAll();

    Menu findById(int id);

    Menu save(Menu menu);

    Menu update(Menu menu);

    void delete(int id);
}
