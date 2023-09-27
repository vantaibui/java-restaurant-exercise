package Controller;

import Model.Menu.Food.Breakfast;
import Service.BreakfastService;

import java.util.List;

public class BreakfastController {
    private BreakfastService breakfastService = null;

    public BreakfastController(BreakfastService breakfastService) {
        this.breakfastService = breakfastService;
    }

    public List<Breakfast> getAllBreakfast() {
        return breakfastService.getAll();
    }

    public Breakfast getBreakfastDetail(int id) {
        return breakfastService.getBreakfastDetail(id);
    }

    public List<Breakfast> saveManyBreakfast(List<Breakfast> breakfastList) {
        return breakfastService.saveManyBreakfast(breakfastList);
    }

    public List<Breakfast> save(Breakfast breakfast) {
        return breakfastService.save(breakfast);
    }

    public Breakfast update(Breakfast breakfast) {
        return breakfastService.update(breakfast);
    }

    public boolean delete(int id) {
        return breakfastService.delete(id);
    }
}
