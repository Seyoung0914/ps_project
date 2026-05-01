package service;

import model.Menu;

import java.util.List;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    @Override
    public void addMenu(Scanner sc, List<Menu> menuList) {
        sc.nextLine();

        System.out.print("메뉴의 이름 > ");
        String name = sc.nextLine();

        System.out.print("메뉴의 가격 > ");
        int price = sc.nextInt();

        System.out.println("메뉴의 타입");
        System.out.println("1. 든든한동");
        System.out.println("2. 따스한동");
        System.out.println("3. Fry Fry");
        System.out.println("4. H:Plate");
        System.out.println("5. Asian Market");
        System.out.print("선택 > ");
        int type = sc.nextInt();

        Menu menuItem = new Menu(name, price, type);
        menuList.add(menuItem);

        System.out.println("메뉴가 추가되었습니다.");
    }

    @Override
    public void printMenu(List<Menu> menuList) {
        if (menuList.isEmpty()) {
            System.out.println("등록된 메뉴가 없습니다.");
            return;
        }

        System.out.println("===== 전체 메뉴 =====");
        for (Menu menu : menuList) {
            System.out.println(menu);
        }
    }

    @Override
    public void updateMenu(Scanner sc, List<Menu> menuList) {
        if (menuList.isEmpty()) {
            System.out.println("수정할 메뉴가 없습니다.");
            return;
        }

        sc.nextLine();

        System.out.print("수정할 메뉴 이름 > ");
        String targetName = sc.nextLine();

        Menu targetMenu = null;

        for (Menu menu : menuList) {
            if (menu.getName().equals(targetName)) {
                targetMenu = menu;
                break;
            }
        }

        if (targetMenu == null) {
            System.out.println("해당 메뉴를 찾을 수 없습니다.");
            return;
        }

        System.out.print("새 메뉴 이름 > ");
        String newName = sc.nextLine();

        System.out.print("새 메뉴 가격 > ");
        int newPrice = sc.nextInt();

        System.out.println("새 메뉴 타입");
        System.out.println("1. 든든한동");
        System.out.println("2. 따스한동");
        System.out.println("3. Fry Fry");
        System.out.println("4. H:Plate");
        System.out.println("5. Asian Market");
        System.out.print("선택 > ");
        int newType = sc.nextInt();

        targetMenu.setName(newName);
        targetMenu.setPrice(newPrice);
        targetMenu.setType(newType);

        System.out.println("메뉴가 수정되었습니다.");
    }

    @Override
    public void deleteMenu(Scanner sc, List<Menu> menuList) {
        if (menuList.isEmpty()) {
            System.out.println("삭제할 메뉴가 없습니다.");
            return;
        }

        sc.nextLine();

        System.out.print("삭제할 메뉴 이름 > ");
        String targetName = sc.nextLine();

        Menu targetMenu = null;

        for (Menu menu : menuList) {
            if (menu.getName().equals(targetName)) {
                targetMenu = menu;
                break;
            }
        }

        if (targetMenu == null) {
            System.out.println("해당 메뉴를 찾을 수 없습니다.");
            return;
        }

        menuList.remove(targetMenu);
        System.out.println("메뉴가 삭제되었습니다.");
    }

    @Override
    public void searchMenu(Scanner sc, List<Menu> menuList) {
        if (menuList.isEmpty()) {
            System.out.println("검색할 메뉴가 없습니다.");
            return;
        }

        sc.nextLine();

        System.out.print("검색할 메뉴 이름 > ");
        String keyword = sc.nextLine();

        boolean found = false;

        System.out.println("===== 검색 결과 =====");
        for (Menu menu : menuList) {
            if (menu.getName().contains(keyword)) {
                System.out.println(menu);
                found = true;
            }
        }

        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    @Override
    public void analyzeSystem(List<Menu> menuList) {
        if (menuList.isEmpty()) {
            System.out.println("분석할 메뉴가 없습니다.");
            return;
        }

        int totalPrice = 0;
        int maxPrice = menuList.get(0).getPrice();
        int minPrice = menuList.get(0).getPrice();

        Menu maxMenu = menuList.get(0);
        Menu minMenu = menuList.get(0);

        int type1Count = 0;
        int type2Count = 0;
        int type3Count = 0;
        int type4Count = 0;
        int type5Count = 0;

        for (Menu menu : menuList) {
            int price = menu.getPrice();
            totalPrice += price;

            if (price > maxPrice) {
                maxPrice = price;
                maxMenu = menu;
            }

            if (price < minPrice) {
                minPrice = price;
                minMenu = menu;
            }

            if (menu.getType() == 1) {
                type1Count++;
            } else if (menu.getType() == 2) {
                type2Count++;
            } else if (menu.getType() == 3) {
                type3Count++;
            } else if (menu.getType() == 4) {
                type4Count++;
            } else if (menu.getType() == 5) {
                type5Count++;
            }
        }

        double averagePrice = (double) totalPrice / menuList.size();

        System.out.println("===== 메뉴 분석 결과 =====");
        System.out.println("전체 메뉴 개수: " + menuList.size());
        System.out.println("메뉴 평균 가격: " + averagePrice + "원");
        System.out.println("가장 비싼 메뉴: " + maxMenu);
        System.out.println("가장 저렴한 메뉴: " + minMenu);

        System.out.println();
        System.out.println("===== 식당 타입별 메뉴 개수 =====");
        System.out.println("든든한동: " + type1Count + "개");
        System.out.println("따스한동: " + type2Count + "개");
        System.out.println("Fry Fry: " + type3Count + "개");
        System.out.println("H:Plate: " + type4Count + "개");
        System.out.println("Asian Market: " + type5Count + "개");
    }
}