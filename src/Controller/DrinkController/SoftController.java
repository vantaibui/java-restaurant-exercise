package Controller.DrinkController;

import Model.Menu.Drink.Soft;
import Service.SoftService;

import java.util.List;

public class SoftController {
    private SoftService softService = null;

    public SoftController(SoftService softService) {
        this.softService = softService;
    }

    public List<Soft> getAllSoft() {
        return softService.getAll();
    }

    public Soft getSoftDetail(int id) {
        return softService.getSoftDetail(id);
    }

    public List<Soft> save(Soft soft) {
        return softService.save(soft);
    }

    public Soft update(Soft soft) {
        return softService.update(soft);
    }

    public boolean delete(int id) {
        return softService.delete(id);
    }
}
