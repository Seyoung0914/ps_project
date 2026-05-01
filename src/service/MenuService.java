package service;

import model.Menu;

import java.util.List;
import java.util.Scanner;

public interface MenuService {
    void addMenu(Scanner sc, List<Menu> menuList);

    void printMenu(List<Menu> menuList);

    void updateMenu(Scanner sc, List<Menu> menuList);

    void deleteMenu(Scanner sc, List<Menu> menuList);

    void searchMenu(Scanner sc, List<Menu> menuList);

    void analyzeSystem(List<Menu> menuList);
}