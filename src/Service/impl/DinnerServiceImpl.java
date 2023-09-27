package Service.impl;

import Model.Menu.Food.Dinner;
import Repository.DinnerRepository;
import Service.DinnerService;

import java.util.List;

public class DinnerServiceImpl implements DinnerService {
    private DinnerRepository dinnerRepository;

    public DinnerServiceImpl(DinnerRepository dinnerRepository) {
        this.dinnerRepository = dinnerRepository;
    }

    @Override
    public List<Dinner> getAll() {
        return dinnerRepository.getAll();
    }

    @Override
    public Dinner getDinnerDetail(int id) {
        return dinnerRepository.findById(id);
    }


    @Override
    public List<Dinner> save(Dinner dinner) {
        return dinnerRepository.save(dinner);
    }

    @Override
    public Dinner update(Dinner dinner) {
        return dinnerRepository.update(dinner);
    }

    @Override
    public boolean delete(int id) {
        return dinnerRepository.delete(id);
    }
}
