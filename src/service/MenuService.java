package service;

import model.Menu;

import java.util.List;

public interface MenuService {
    void addMenu(List<Menu> menuList);

    void printMenu(List<Menu> menuList);

    void updateMenu(List<Menu> menuList);

    void deleteMenu(List<Menu> menuList);

    void searchMenu(List<Menu> menuList);

    void analyzeSystem(List<Menu> menuList);
}