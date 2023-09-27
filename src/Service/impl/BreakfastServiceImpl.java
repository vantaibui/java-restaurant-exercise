package Service.impl;

import Model.Menu.Food.Breakfast;
import Repository.BreakfastRepository;
import Repository.impl.BreakfastRepositoryImpl;
import Service.BreakfastService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BreakfastServiceImpl implements BreakfastService {
    private BreakfastRepository breakfastRepository;
    public BreakfastServiceImpl(BreakfastRepository breakfastRepository) {
        this.breakfastRepository = breakfastRepository;
    }

    @Override
    public List<Breakfast> getAll() {
        return breakfastRepository.getAll();
    }

    @Override
    public Breakfast getBreakfastDetail(int id) {
        return breakfastRepository.findById(id);
    }

    @Override
    public List<Breakfast> saveManyBreakfast(List<Breakfast> breakfastList) {
        return breakfastRepository.saveManyBreakfast(breakfastList);
    }

    @Override
    public List<Breakfast> save(Breakfast breakfast) {
        return breakfastRepository.save(breakfast);
    }

    @Override
    public Breakfast update(Breakfast breakfast) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
