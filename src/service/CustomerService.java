package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	private Map<String,Customer> customers;
	private static final CustomerService instance = new CustomerService();
	public CustomerService() {
		customers = new HashMap<String,Customer>();
	}
	public void addCustomer(Customer customer){
		customers.put(customer.getId(), customer);
	}
	public static CustomerService getInstance(){
		return instance;
	}
	public Customer login(String id, String password){
		if(id != null){
			Customer tempCustomer = customers.get(id.toLowerCase());
			if(tempCustomer == null)
				return null;
			if(tempCustomer.getPassword().equals(password)){
				return tempCustomer;
			}
			else
				return null;
		}
		else
			return null;
	}
	public Customer findCustomer(String id){
		if(id != null)
			return(customers.get(id.toLowerCase()));
		else
			return null;
	}
}
