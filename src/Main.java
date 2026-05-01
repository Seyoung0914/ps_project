import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        Manager manager = new Manager(sc, menuService, customerService);
        manager.run();
    }
}
