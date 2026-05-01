import service.Manager;
import service.MenuService;
import service.MenuServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuServiceImpl();
        Manager manager = new Manager(sc, menuService);
    }
}
