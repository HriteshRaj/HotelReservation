package service;

import model.Customer;

import java.util.Collection;

public class CustomerService {


    public void addCustomer(String email,String firstName,String lastName){
        Customer customer = new Customer(email,firstName,lastName);
    }

    public static Customer getCustomer(String customerEmail){
        return null;
    }
    public static Collection<Customer> getAllCustomers(){
        return null;
    }




}
