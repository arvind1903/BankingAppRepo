package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repository.BankingServiceRepo;

@Service
public class BankingService {

	@Autowired
	BankingServiceRepo bankingServiceRepo;
	
	public String depositeAmount(String accNo,double amount) {
		
		Customer customer =  bankingServiceRepo.getCustomerByAccNo(accNo);
		
		customer.setAmount(customer.getAmount()+amount);
		
		bankingServiceRepo.saveCustomerData(customer, accNo);
		
		return " Amount Deposited Successfully";
	}
	
	public String withdrawAmount(String accNo,double amount) {
		
		Customer customer =  bankingServiceRepo.getCustomerByAccNo(accNo);
		
		customer.setAmount(customer.getAmount()-amount);
		
		bankingServiceRepo.saveCustomerData(customer, accNo);
		
		return "Amount Withdraw Successfully";
	}
	
	public void createCustomerAccount(Customer customer) {
		bankingServiceRepo.saveCustomerData(customer, customer.getAccNo());
		System.out.println(customer);
	}

	public Double checkBalance(String accNo) {
		return bankingServiceRepo.retriveAccountBalance(accNo);
	}
}
