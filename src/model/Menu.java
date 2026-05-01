package model;

public class Menu {
    private String name;
    private int type;
    private int price;

    public Menu(){
    }
    public Menu(String name, int price, int type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "음식 이름: " + name +
                ", 식당: " + type +
                ", 가격: " + price + "원";
    }
}
