package Service;

import java.util.List;

public interface MenuService<T> {
    List<T> getAll();
    T findById(int id);
    T save(T t);
    T update(T t);
    void delete(int id);

}
