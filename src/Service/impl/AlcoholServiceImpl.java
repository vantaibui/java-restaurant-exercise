package Service.impl;

import Model.Menu.Drink.Alcohol;
import Repository.AlcoholRepository;
import Service.AlcoholService;

import java.util.List;

public class AlcoholServiceImpl implements AlcoholService {
    private AlcoholRepository alcoholRepository;

    public AlcoholServiceImpl(AlcoholRepository alcoholRepository) {
        this.alcoholRepository = alcoholRepository;
    }

    @Override
    public List<Alcohol> getAll() {
        return alcoholRepository.getAll();
    }

    @Override
    public Alcohol getAlcoholDetail(int id) {
        return alcoholRepository.findById(id);
    }

    @Override
    public List<Alcohol> save(Alcohol alcohol) {
        return alcoholRepository.save(alcohol);
    }

    @Override
    public Alcohol update(Alcohol alcohol) {
        return alcoholRepository.update(alcohol);
    }

    @Override
    public boolean delete(int id) {
        return alcoholRepository.delete(id);
    }
}
