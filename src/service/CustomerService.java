package service;

import model.Customer;
import model.Menu;

import java.util.List;

public interface CustomerService {
    void registerCustomer(List<Customer> customerList);

    Customer login(List<Customer> customerList);

    void printCustomers(List<Customer> customerList);

    void orderFood(Customer loginCustomer, List<Menu> menuList);
}