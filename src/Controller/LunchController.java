package Controller;

import Model.Menu.Food.Lunch;
import Service.LunchService;

import java.util.List;

public class LunchController {
    private LunchService lunchService = null;

    public LunchController(LunchService lunchService) {
        this.lunchService = lunchService;
    }

    public List<Lunch> getAllLunch() {
        return lunchService.getAll();
    }

    public Lunch getLunchDetail(int id) {
        return lunchService.getLunchDetail(id);
    }

    public List<Lunch> save(Lunch lunch) {
        return lunchService.save(lunch);
    }

    public Lunch update(Lunch lunch) {
        return lunchService.update(lunch);
    }

    public boolean delete(int id) {
        return lunchService.delete(id);
    }
}
