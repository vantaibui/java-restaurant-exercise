package Service.impl;

import Model.Menu.Food.Lunch;
import Repository.LunchRepository;
import Service.LunchService;

import java.util.List;

public class LunchServiceImpl implements LunchService {
    private LunchRepository lunchRepository;

    public LunchServiceImpl(LunchRepository lunchRepository) {
        this.lunchRepository = lunchRepository;
    }

    @Override
    public List<Lunch> getAll() {
        return lunchRepository.getAll();
    }

    @Override
    public Lunch getLunchDetail(int id) {
        return lunchRepository.findById(id);
    }

    @Override
    public List<Lunch> save(Lunch lunch) {
        return lunchRepository.save(lunch);
    }

    @Override
    public Lunch update(Lunch lunch) {
        return lunchRepository.update(lunch);
    }

    @Override
    public boolean delete(int id) {
        return lunchRepository.delete(id);
    }
}
