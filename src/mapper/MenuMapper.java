package mapper;

import dto.MenuDTO;
import entity.Menu;

public class MenuMapper {
    private static MenuMapper INSTANCE;

    private MenuMapper() {
    }

    public static MenuMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MenuMapper();
        }
        return INSTANCE;
    }

    public Menu toEntity(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setId(menuDTO.getId());

        return menu;
    }

    public MenuDTO toDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        return menuDTO;
    }
}
