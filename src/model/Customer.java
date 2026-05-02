package model;

// ArrayList를 사용하기 위해 import
// ArrayList는 여러 개의 데이터를 순서대로 저장할 수 있는 리스트 자료구조

import java.util.ArrayList;

public class Customer {

    // 고객 이름, 아이디, 비밀번호를 저장하는 변수
    private String name, userId, password;

    // 고객이 현재 가지고 있는 잔액
    private int balance;

    // 고객이 주문한 메뉴들을 저장하는 리스트
    private ArrayList<Menu> menuList;

    // 기본 생성자
    // 객체를 만들 때 값을 바로 넣지 않고 나중에 setter로 넣고 싶을 때 사용 가능
    public Customer() {
    }

    // 고객 정보를 한 번에 넣어서 객체를 만들 때 사용하는 생성자
    public Customer(String name, String userId, String password, int balance) {
        this.name = name;           // 입력받은 name 값을 현재 객체의 name에 저장
        this.userId = userId;       // 입력받은 userId 값을 현재 객체의 userId에 저장
        this.password = password;   // 입력받은 password 값을 현재 객체의 password에 저장
        this.balance = balance;     // 입력받은 balance 값을 현재 객체의 balance에 저장

        // 주문 메뉴 리스트 초기화
        this.menuList = new ArrayList<>();
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }

    public void setMenu(Menu menu) {
        menuList.add(menu);
    }

    @Override
    public String toString() {
        return "이름: " + name +
                " | 아이디: " + userId +
                " | 잔액: " + balance + "원" +
                " | 주문 메뉴: " + menuList;
    }
}