package service;

import model.Customer;
import model.Menu;

import java.util.List;


public interface CustomerService {

    // 회원가입 기능
    // customerList에 새 Customer 객체를 추가하는 역할
    void registerCustomer(List<Customer> customerList);

    // 로그인 기능
    // customerList에서 아이디와 비밀번호가 일치하는 고객을 찾아 반환함
    // 로그인 성공 시 Customer 객체 반환
    // 로그인 실패 시 null 반환 가능
    Customer login(List<Customer> customerList);

    // 전체 회원 목록 출력 기능
    // customerList에 저장된 모든 고객 정보를 출력함
    void printCustomers(List<Customer> customerList);

    // 음식 주문 기능
    // loginCustomer: 현재 로그인한 고객
    // menuList: 주문 가능한 전체 메뉴 목록
    // 고객이 메뉴를 선택하면 잔액 차감, 재고 감소, 주문 처리 등을 수행함
    void orderFood(Customer loginCustomer, List<Menu> menuList);

    // 고객 목록 저장 기능
    // customerList에 있는 고객 정보를 파일에 저장함
    void saveCustomerList(List<Customer> customerList);

    // 고객 목록 불러오기 기능
    // 파일에 저장된 고객 정보를 읽어서 customerList에 추가함
    // 프로그램 시작할 때 호출하여 이전 회원 정보를 다시 사용할 수 있음
    void loadCustomerList(List<Customer> customerList);
}