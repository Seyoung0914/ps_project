package service;

import model.Customer;

import java.util.List;
import java.util.Scanner;

public interface CustomerService {
    void registerCustomer(Scanner sc, List<Customer> customerList);

    Customer login(Scanner sc, List<Customer> customerList);

    void printCustomers(List<Customer> customerList);
}