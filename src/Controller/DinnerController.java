package Controller;

import Model.Menu.Food.Dinner;
import Service.DinnerService;

import java.util.List;

public class DinnerController {
    private DinnerService dinnerService = null;

    public DinnerController(DinnerService dinnerService) {
        this.dinnerService = dinnerService;
    }

    public List<Dinner> getAllDinner() {
        return dinnerService.getAll();
    }

    public Dinner getDinnerDetail(int id) {
        return dinnerService.getDinnerDetail(id);
    }

    public List<Dinner> save(Dinner dinner) {
        return dinnerService.save(dinner);
    }

    public Dinner update(Dinner dinner) {
        return dinnerService.update(dinner);
    }

    public boolean delete(int id) {
        return dinnerService.delete(id);
    }
}
