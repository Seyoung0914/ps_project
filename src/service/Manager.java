package service;

import model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private Scanner sc;
    private MenuServiceImpl menuService;
    private List<Menu> menuList;

    public Manager() {
    }

    public Manager(Scanner sc, MenuServiceImpl menuService) {
        this.sc = sc;
        this.menuService = menuService;
        this.menuList = new ArrayList<>();
    }

    public void run() {
        int menu;

        while (true) {
            System.out.println("===== 학관 온라인 주문 프로그램 =====");
            System.out.println("1. 관리자 메뉴");
            System.out.println("2. 고객 메뉴");
            System.out.println("0. 프로그램 종료");
            System.out.println("================================");
            System.out.print("선택 > ");

            menu = sc.nextInt();

            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            if (menu == 1) {
                while (true) {
                    System.out.println("========== 관리자 메뉴 ==========");
                    System.out.println("1. 메뉴 추가");
                    System.out.println("2. 메뉴 리스트 출력");
                    System.out.println("3. 메뉴 수정");
                    System.out.println("4. 메뉴 삭제");
                    System.out.println("5. 메뉴 검색");
                    System.out.println("6. 메뉴 분석");
                    System.out.println("0. 이전 메뉴");
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

                        case 0:
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            break;

                        default:
                            System.out.println("잘못된 입력입니다.");
                            break;
                    }
                }
            } else if (menu == 2) {
                while (true) {
                    System.out.println("=========== 고객 메뉴 ===========");
                    System.out.println("1. 음식 주문");
                    System.out.println("2. 회원가입");
                    System.out.println("0. 이전 메뉴");
                    System.out.println("================================");
                    System.out.print("선택 > ");

                    menu = sc.nextInt();

                    switch (menu) {
                        case 1:
                            menuService.orderMenu();
                            break;

                        case 2:
                            menuService.registerSystem();
                            break;

                        case 0:
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            break;

                        default:
                            System.out.println("잘못된 입력입니다.");
                            break;
                    }
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}