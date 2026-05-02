package model;

public class Menu {
    private String name;
    private int type;
    private int price;
    private String description;
    private int stock;
    private static final String[] RESTAURANTS = {"든든한동", "따스한동", "Fry Fry", "H:Plate", "Asian Market"};

    public Menu() {
    }

    public Menu(String name, int price, int type, String description, int stock) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "음식 이름: " + name +
                ", 식당: " + RESTAURANTS[type-1] +
                ", 가격: " + price + "원" +
                ", 설명: " + description +
                ", 판매 개수: " + stock + "개";
    }
}