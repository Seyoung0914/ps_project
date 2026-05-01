package service;

import model.Customer;
import model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private Scanner sc;
    private MenuService menuService;
    private CustomerService customerService;
    private List<Menu> menuList;
    private List<Customer> customerList;
    private Customer loginCustomer;

    public Manager() {
    }

    public Manager(Scanner sc, MenuService menuService, CustomerService customerService) {
        this.sc = sc;
        this.menuService = menuService;
        this.customerService = customerService;
        this.menuList = new ArrayList<>();
        this.customerList = new ArrayList<>();
        this.loginCustomer = null;
    }

    public void run() {
        int menu;

        while (true) {
            System.out.println("===== 학관 온라인 주문 프로그램 =====");
            System.out.println("1. 관리자 메뉴  2. 고객 메뉴  0. 프로그램 종료");
            System.out.println("================================");
            System.out.print("선택 > ");

            menu = sc.nextInt();

            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            if (menu == 1) {
                boolean isAdminMenu = true;

                while (isAdminMenu) {
                    System.out.println("========== 관리자 메뉴 ==========");
                    System.out.println("1. 메뉴 추가  2. 메뉴 리스트 출력  3. 메뉴 수정  4. 메뉴 삭제");
                    System.out.println("5. 메뉴 검색  6. 메뉴 분석  7. 회원 목록 출력  0. 이전 메뉴");
                    System.out.println("================================");
                    System.out.print("선택 > ");

                    menu = sc.nextInt();

                    switch (menu) {
                        case 1:
                            menuService.addMenu(sc, menuList);
                            break;

                        case 2:
                            menuService.printMenu(menuList);
                            break;

                        case 3:
                            menuService.updateMenu(sc, menuList);
                            break;

                        case 4:
                            menuService.deleteMenu(sc, menuList);
                            break;

                        case 5:
                            menuService.searchMenu(sc, menuList);
                            break;

                        case 6:
                            menuService.analyzeSystem(menuList);
                            break;

                        case 7:
                            customerService.printCustomers(customerList);
                            break;

                        case 0:
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            isAdminMenu = false;
                            break;

                        default:
                            System.out.println("잘못된 입력입니다.");
                            break;
                    }
                }

            } else if (menu == 2) {
                boolean isCustomerMenu = true;

                while (isCustomerMenu) {
                    System.out.println("=========== 고객 메뉴 ===========");
                    System.out.println("1. 회원가입  2. 로그인  3. 음식 주문  4. 현재 로그인 사용자 확인  0. 이전 메뉴");
                    System.out.println("================================");
                    System.out.print("선택 > ");

                    menu = sc.nextInt();

                    switch (menu) {
                        case 1:
                            customerService.registerCustomer(sc, customerList);
                            break;

                        case 2:
                            loginCustomer = customerService.login(sc, customerList);

                            if (loginCustomer != null) {
                                System.out.println("현재 로그인 사용자: " + loginCustomer.getName());
                            }
                            break;

                        case 3:
                            if (loginCustomer == null) {
                                System.out.println("로그인 후 주문할 수 있습니다.");
                            } else {
                                customerService.orderFood(sc, loginCustomer, menuList);
                            }
                            break;

                        case 4:
                            if (loginCustomer == null) {
                                System.out.println("현재 로그인된 사용자가 없습니다.");
                            } else {
                                System.out.println("현재 로그인 사용자: " + loginCustomer.getName());
                            }
                            break;

                        case 0:
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            isCustomerMenu = false;
                            break;

                        default:
                            System.out.println("잘못된 입력입니다.");
                            break;
                    }
                }
            }
        }
    }
}