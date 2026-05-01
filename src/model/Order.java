package model;

public class Order {
    private int orderId;
    private int status;
    private int quantity;
    private int type;
    private Menu menu;

    public Order() {
    }
    public Order(int orderId, int status, int quantity, int type, Menu menu) {
        this.orderId = orderId;
        this.status = status;
        this.quantity = quantity;
        this.type = type;
        this.menu = menu;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getStatus(){
        return status;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getType() {
        return type;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
