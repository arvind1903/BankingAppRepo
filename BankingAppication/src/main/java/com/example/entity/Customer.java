package com.example.entity;

public class Customer {

	private String accNo;
	private String accName;
	private String location;
	private Double amount;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", accName=" + accName + ", location=" + location + ", amount=" + amount
				+ "]";
	}
}
