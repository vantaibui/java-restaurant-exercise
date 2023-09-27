package Service.impl;

import Model.Menu.Menu;
import Repository.*;
import Service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MenuServiceImpl implements MenuService {
    private BreakfastRepository breakfastRepository;
    private LunchRepository lunchRepository;
    private DinnerRepository dinnerRepository;
    private AlcoholRepository alcoholRepository;
    private SoftRepository softRepository;

    public MenuServiceImpl(BreakfastRepository breakfastRepository, LunchRepository lunchRepository, DinnerRepository dinnerRepository, AlcoholRepository alcoholRepository, SoftRepository softRepository) {
        this.breakfastRepository = breakfastRepository;
        this.lunchRepository = lunchRepository;
        this.dinnerRepository = dinnerRepository;
        this.alcoholRepository = alcoholRepository;
        this.softRepository = softRepository;
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> menuList = new ArrayList<>();
        menuList.addAll(breakfastRepository.getAll());
        menuList.addAll(lunchRepository.getAll());
        menuList.addAll(dinnerRepository.getAll());
        menuList.addAll(alcoholRepository.getAll());
        menuList.addAll(softRepository.getAll());
        return menuList;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
