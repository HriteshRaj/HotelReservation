package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;

public class CustomerService {



    static HashMap<String,Customer> customers = new HashMap<>();

    private static  CustomerService instance = new CustomerService();

    private CustomerService(){

    }

    public static CustomerService getInstance(){


        return instance;

    }


    public void addCustomer(String email,String firstName,String lastName){

        Customer customer = new Customer(email,firstName,lastName);

        customers.put(email,customer);
    }

    public  Customer getCustomer(String customerEmail){

        return customers.get(customerEmail);

    }
    public  Collection<Customer> getAllCustomers(){


        Collection<Customer> customerLists =customers.values();

        return  customerLists;
    }




}
