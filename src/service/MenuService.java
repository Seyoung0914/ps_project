package service;

import model.Menu;

import java.util.List;

public interface MenuService {

    // 메뉴 추가 기능
    // menuList에 새 Menu 객체를 추가하는 역할
    void addMenu(List<Menu> menuList);

    // 전체 메뉴 출력 기능
    // menuList에 저장된 모든 메뉴 정보를 출력함
    void printMenu(List<Menu> menuList);

    // 메뉴 수정 기능
    // 기존 menuList에서 특정 메뉴를 찾아 이름, 가격, 타입, 설명, 재고를 수정함
    void updateMenu(List<Menu> menuList);

    // 메뉴 삭제 기능
    // 기존 menuList에서 특정 메뉴를 찾아 삭제함
    void deleteMenu(List<Menu> menuList);

    // 메뉴 검색 기능
    // 메뉴 이름 등을 기준으로 menuList에서 원하는 메뉴를 찾아 출력함
    void searchMenu(List<Menu> menuList);

    // 메뉴 분석 기능
    // 식당 타입별 메뉴 개수를 분석해서 출력함
    void analyzeSystem(List<Menu> menuList);

    // 메뉴 목록 저장 기능
    // menuList에 있는 메뉴 정보를 파일에 저장함
    void saveMenuList(List<Menu> menuList);

    // 메뉴 목록 불러오기 기능
    // 파일에 저장된 메뉴 정보를 읽어서 menuList에 추가함
    // 프로그램 시작할 때 호출하여 이전 메뉴 정보를 다시 사용할 수 있음
    void loadMenuList(List<Menu> menuList);
}