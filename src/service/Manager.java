package service;

import java.util.Scanner;

public class Manager {
    public void run(Scanner sc) {
        int menu;
        while (true) {
            System.out.println("===== 학관 온라인 주문 프로그램 =====");
            System.out.println("1.관리자메뉴\n2.고객메뉴\n0.프로그램 종료");
            System.out.println("================================");
            menu = sc.nextInt();

            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            if (menu == 1) {
                while (true) {
                    System.out.println("========== 관리자 메뉴 ==========");
                    System.out.println("1.메뉴추가\n2.메뉴리스트출력\n3.메뉴수정\n4.메뉴삭제\n5.메뉴검색\n6.분석.,\n0.이전메뉴");
                    System.out.println("================================");
                    menu = sc.nextInt();
                    switch (menu) {
//                메뉴등록
                        case 1:
                            addMenu();
                            break;
//                메뉴리스트 출력
                        case 2:
                            printMenu();
                            break;
//                메뉴리스트 변경
                        case 3:
                            updateMenu();
                            break;
//                메뉴리스트 삭제
                        case 4:
                            deleteMenu();
                            break;
//                메뉴검색
                        case 5:
                            searchMenu();
                            break;
//                주문하기
                        case 6:
                            analyzeSystem();
                            break;
                        default:
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            break;
                    }
                }
            } else if (menu == 2) {
                while (true) {
                    System.out.println("=========== 고객 메뉴 ===========");
                    System.out.println("1.음식주문\n2.회원가입\n0.이전메뉴");
                    System.out.println("================================");
                    menu = sc.nextInt();
                    switch (menu) {
                        case 1:
                            orderMenu();
                        case 2:
                            //                회원가입
                            registerSystem();
                            break;
                        default:
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            break;
                    }
                }
            }

        }
//        고객 음식 주문 요청
//        메뉴를 보여주고 원하는 음식을 입력받음
//        음식 정보랑 번호를 지정한뒤에 손님에게 번호표 보여줌
//        요리사에게 전달
//        요리사는 음식을 조리하고 조리가 끝나면 상태를 변경
//        상태가 변경되면 손님에게 음식이 준비되었다고 알림
    }
}
