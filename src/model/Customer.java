package model;

import java.util.ArrayList;

public class Customer {
    private String name, userId, password;
    private int balance;
    private ArrayList<Menu> menuList;

    public Customer(){}
    public Customer(String name, String userId, String password, int balance){
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }

    public void setMenu(Menu menu){
        if(balance<menu.getPrice()){System.out.println("잔고가 부족합니다."); return;}
        balance -= menu.getPrice();
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
