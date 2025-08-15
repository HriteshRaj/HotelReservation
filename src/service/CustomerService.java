package service;

import model.Customer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class CustomerService {

    static HashMap<String,Customer> customers = new HashMap<>();



    public void addCustomer(String email,String firstName,String lastName){
        Customer customer = new Customer(email,firstName,lastName);
        customers.put(email,customer);
    }

    public static Customer getCustomer(String customerEmail){
        return null;
    }
    public  Collection<Customer> getAllCustomers(){
        Collection<Customer> customerLists =customers.values();
        return  customerLists;
    }




}
