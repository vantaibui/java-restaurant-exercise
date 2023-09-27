package Service.impl;

import Model.Menu.Drink.Soft;
import Repository.SoftRepository;
import Service.SoftService;

import java.util.List;

public class SoftServiceImpl implements SoftService {
    private SoftRepository softRepository;

    public SoftServiceImpl(SoftRepository softRepository) {
        this.softRepository = softRepository;
    }

    @Override
    public List<Soft> getAll() {
        return softRepository.getAll();
    }

    @Override
    public Soft getSoftDetail(int id) {
        return softRepository.findById(id);
    }

    @Override
    public List<Soft> save(Soft soft) {
        return softRepository.save(soft);
    }

    @Override
    public Soft update(Soft soft) {
        return softRepository.update(soft);
    }

    @Override
    public boolean delete(int id) {
        return softRepository.delete(id);
    }
}
