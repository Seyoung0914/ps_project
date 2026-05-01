package service;

import model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void registerCustomer(Scanner sc, List<Customer> customerList) {
        sc.nextLine();

        System.out.print("이름 > ");
        String name = sc.nextLine();

        System.out.print("학번 > ");
        String studentId = sc.nextLine();

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
    public Customer login(Scanner sc, List<Customer> customerList) {
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

    public Customer findCustomerByUserId(String userId, List<Customer> customerList) {
        for (Customer customer : customerList) {
            if (customer.getUserId().equals(userId)) {
                return customer;
            }
        }

        return null;
    }
}