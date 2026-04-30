package model;

public class Order {
    private int orderId;
    private int status;
    private int quantity;
    private int type;
    private Menu menu;

    public int getStatus(){
        return status;
    }
}
