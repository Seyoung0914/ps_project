package service;

import model.Customer;
import model.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Scanner sc;
    private static final String CUSTOMER_FILE_PATH = "customer.txt";

    public CustomerServiceImpl(){}
    public CustomerServiceImpl(Scanner sc){
        this.sc = sc;
    }

    @Override
    public void registerCustomer(List<Customer> customerList) {
        sc.nextLine();

        System.out.print("이름 > ");
        String name = sc.nextLine();

        System.out.print("아이디 > ");
        String userId = sc.nextLine();

        if (findCustomerByUserId(userId, customerList) != null) {
            System.out.println("이미 존재하는 아이디입니다.");
            return;
        }

        System.out.print("비밀번호 > ");
        String password = sc.nextLine();

        System.out.print("잔액 > ");
        int balance = sc.nextInt();

        Customer customer = new Customer(name, userId, password, balance);
        customerList.add(customer);

        System.out.println("회원가입이 완료되었습니다.");
    }

    @Override
    public Customer login(List<Customer> customerList) {
        sc.nextLine();

        System.out.print("아이디 > ");
        String userId = sc.nextLine();

        System.out.print("비밀번호 > ");
        String password = sc.nextLine();

        for (Customer customer : customerList) {
            if (customer.getUserId().equals(userId)
                    && customer.getPassword().equals(password)) {
                System.out.println(customer.getName() + "님 로그인 성공!");
                return customer;
            }
        }

        System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
        return null;
    }

    @Override
    public void printCustomers(List<Customer> customerList) {
        if (customerList.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }

        System.out.println("===== 회원 목록 =====");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void orderFood(Customer loginCustomer, List<Menu> menuList) {
        if (menuList.isEmpty()) {
            System.out.println("등록된 메뉴가 없습니다.");
            return;
        }

        System.out.println("===== 주문 가능 메뉴 =====");

        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i));
        }

        System.out.print("주문할 메뉴 번호 > ");
        int menuNumber = sc.nextInt();

        if (menuNumber < 1 || menuNumber > menuList.size()) {
            System.out.println("잘못된 메뉴 번호입니다.");
            return;
        }

        Menu selectedMenu = menuList.get(menuNumber - 1);

        System.out.print("주문 개수 > ");
        int count = sc.nextInt();

        if (selectedMenu.getStock() < count) {
            System.out.println("재고가 부족합니다.");
            System.out.println("현재 재고: " + selectedMenu.getStock() + "개");
            System.out.println("주문 요청 개수: " + count + "개");
            return;
        }

        int totalPrice = selectedMenu.getPrice() * count;

        if (loginCustomer.getBalance() < totalPrice) {
            System.out.println("잔액이 부족합니다.");
            System.out.println("현재 잔액: " + loginCustomer.getBalance() + "원");
            System.out.println("주문 금액: " + totalPrice + "원");
            return;
        }

        loginCustomer.setBalance(loginCustomer.getBalance() - totalPrice);
        selectedMenu.setStock(selectedMenu.getStock() - count);

        System.out.println("주문이 완료되었습니다.");
        System.out.println("주문자: " + loginCustomer.getName());
        System.out.println("주문 메뉴: " + selectedMenu.getName());
        System.out.println("주문 개수: " + count);
        System.out.println("결제 금액: " + totalPrice + "원");
        System.out.println("남은 잔액: " + loginCustomer.getBalance() + "원");
    }

    public Customer findCustomerByUserId(String userId, List<Customer> customerList) {
        for (Customer customer : customerList) {
            if (customer.getUserId().equals(userId)) {
                return customer;
            }
        }
        return null;
    }

    public void saveCustomerList(List<Customer> customerList) {
        try {
            PrintWriter pw = new PrintWriter(CUSTOMER_FILE_PATH);

            for (Customer customer : customerList) {
                pw.println(
                        customer.getName() + "|" +
                                customer.getUserId() + "|" +
                                customer.getPassword() + "|" +
                                customer.getBalance()
                );
            }

            pw.close();

        } catch (FileNotFoundException e) {
            System.out.println("회원 파일 저장 중 오류가 발생했습니다.");
        }
    }

    public void loadCustomerList(List<Customer> customerList) {
        File file = new File(CUSTOMER_FILE_PATH);

        if (!file.exists()) {
            return;
        }

        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                String[] data = line.split("\\|");

                String name = data[0];
                String userId = data[1];
                String password = data[2];
                int balance = Integer.parseInt(data[3]);

                Customer customer = new Customer(name, userId, password, balance);
                customerList.add(customer);
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("회원 파일을 불러오는 중 오류가 발생했습니다.");
        }
    }
}