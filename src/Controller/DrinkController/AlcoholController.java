package Controller.DrinkController;

import Model.Menu.Drink.Alcohol;
import Service.AlcoholService;

import java.util.List;

public class AlcoholController {
    private AlcoholService alcoholService = null;

    public AlcoholController(AlcoholService alcoholService) {
        this.alcoholService = alcoholService;
    }

    public List<Alcohol> getAllAlcohol() {
        return alcoholService.getAll();
    }

    public Alcohol getAlcoholDetail(int id) {
        return alcoholService.getAlcoholDetail(id);
    }

    public List<Alcohol> save(Alcohol alcohol) {
        return alcoholService.save(alcohol);
    }

    public Alcohol update(Alcohol alcohol) {
        return alcoholService.update(alcohol);
    }

    public boolean delete(int id) {
        return alcoholService.delete(id);
    }
}
