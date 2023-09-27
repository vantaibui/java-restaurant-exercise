package Controller;

import Model.Menu.Menu;
import Service.MenuService;

import java.util.List;

public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public List<Menu> getAllMenu() {
        return menuService.getAll();
    }
}
