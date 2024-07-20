package com.example.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.entity.Customer;
import com.example.service.BankingService;

@SpringBootApplication
@ComponentScan("com.example.service,com.example.repository,com.example.main.test")
public class BankingAppicationApplication implements CommandLineRunner{

	@Autowired
	BankingService bankingService;
	
	public static void main(String[] args) {
		SpringApplication.run(BankingAppicationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(" inside spring boot application ");
		
		int num = 123;
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println(" Select from the below options: ");
			
			System.out.println("1. Create Account");
			System.out.println("2. Deposit Amount");
			System.out.println("3. Withdraw Amount");
			System.out.println("4. Check Balance");
			System.out.println("5. Exit");
			
			String input = sc.next();
			
			switch(input) {
				case "1" : 
					System.out.println("Enter Account holder name");
					String name = sc.next();
					
					System.out.println("Enter initial Amount");
					Double amount = sc.nextDouble();
					
					System.out.println(" Enter Location");
					String location = sc.next();
					
					Customer customer = new Customer();
					customer.setAccName(name);
					customer.setAmount(amount);
					customer.setLocation(location);
					customer.setAccNo((num++)+"");
					bankingService.createCustomerAccount(customer);
				break;
				
				case "2" :
					System.out.println(" Enter Account Number ");
					String accNo = sc.next();
					System.out.println(" Enter deposit Amount ");
					Double depositAmt = sc.nextDouble();
					bankingService.depositeAmount(accNo, depositAmt);
				break;
				
				case "3" :
					System.out.println(" Enter Account Number ");
					 accNo = sc.next();
					System.out.println(" Enter withdraw Amount ");
					 depositAmt = sc.nextDouble();
					 bankingService.withdrawAmount(accNo, depositAmt);
				break;
				
				case "4" :
					System.out.println(" Enter Accoun Number ");
					accNo = sc.next();
					Double balance = bankingService.checkBalance(accNo);
					System.out.println(" Balance Amount "+balance);
				break;	
					
				case "5" :
					return;
			}
			
		}
	}

}
