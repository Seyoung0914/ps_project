package model;

import java.util.ArrayList;

public class Customer {
    private String name;
    private int balance;
    private ArrayList<Menu> menuList;

    public Customer(){}
    public Customer(String name, int balance){
        this.balance = balance;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void setMenu(Menu menu){
        if(balance<menu.getPrice()){System.out.println("잔고가 부족합니다."); return;}
        balance -= menu.getPrice();
        menuList.add(menu);
    }
}
