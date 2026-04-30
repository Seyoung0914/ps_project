package model;

public class Cook {
//    0: 든든, 1: 따스, 3:프프, 4: Asian
    private int type;

    Cook(){}
    public Cook(int type){
        this.type = type;
    }

    public int cookFood(){
//    주문을 전달받음
        System.out.println("주문이 접수되었습니다.");
        try {
//    조리
            System.out.println("조리중입니다. 잠시만 기다려주세요 ...");
            Thread.sleep(2000);
            System.out.println("음식이 나왔습니다.");
        } catch (InterruptedException e) {
            System.out.println("조리 중 문제가 발생했습니다. 관리자에게 문의 바랍니다.");
            return -1;
        }

//    조리 끝나면 상태를 내보냄
        return 1;
    }

}
