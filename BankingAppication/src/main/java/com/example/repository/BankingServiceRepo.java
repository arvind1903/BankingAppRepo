package com.example.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.entity.Customer;

@Repository
public class BankingServiceRepo {

	private Map<String,Customer> customerdata = new HashMap<String,Customer>();
	
	
	public Map<String, Customer> getCustomerdata() {
		return customerdata;
	}
	
	public Customer getCustomerByAccNo(String accNo) {
		Customer customer = customerdata.get(accNo);
		return customer;
	}
	
	public void saveCustomerData(Customer customer,String accNo) {
		customerdata.put(accNo, customer);
	}

	public Double retriveAccountBalance(String accNo) {
		Customer customer = customerdata.get(accNo);
		return customer.getAmount();
	}
}
