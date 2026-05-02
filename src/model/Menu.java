package model;

public class Menu {

    // 식당 이름들을 배열로 저장
    // type 값이 1이면 RESTAURANTS[0]인 "든든한동"을 의미함
    // type 값이 2이면 RESTAURANTS[1]인 "따스한동"을 의미함
    private static final String[] RESTAURANTS = {
            "든든한동", "따스한동", "Fry Fry", "H:Plate", "Asian Market"
    };
    // 메뉴 이름을 저장하는 변수
    // 예: "김치찌개", "돈까스", "라면"
    private String name;
    // 식당 타입을 숫자로 저장하는 변수
    // 1: 든든한동
    // 2: 따스한동
    // 3: Fry Fry
    // 4: H:Plate
    // 5: Asian Market
    private int type;
    // 메뉴 가격을 저장하는 변수
    // 예: 7000, 8500
    private int price;
    // 메뉴 설명을 저장하는 변수
    // 예: "얼큰한 김치찌개", "바삭한 돈까스"
    private String description;
    // 메뉴 재고를 저장하는 변수
    // 여기서는 실제 의미상 "판매 개수"보다는 "남은 재고 개수"에 가까움
    private int stock;

    // 기본 생성자
    public Menu() {
    }

    // 메뉴 정보를 한 번에 넣어서 Menu 객체를 만들 때 사용하는 생성자
    public Menu(String name, int price, int type, String description, int stock) {
        this.name = name;                 // 입력받은 메뉴 이름을 현재 객체의 name에 저장
        this.price = price;               // 입력받은 가격을 현재 객체의 price에 저장
        this.type = type;                 // 입력받은 식당 타입 번호를 현재 객체의 type에 저장
        this.description = description;   // 입력받은 메뉴 설명을 현재 객체의 description에 저장
        this.stock = stock;               // 입력받은 재고 개수를 현재 객체의 stock에 저장
    }

    // getter, setter
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
                ", 식당: " + RESTAURANTS[type - 1] +
                ", 가격: " + price + "원" +
                ", 설명: " + description +
                ", 판매 개수: " + stock + "개";
    }
}