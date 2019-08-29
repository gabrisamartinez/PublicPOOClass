package com.univille.gabrielly.banco;

public class Conta {
	private String clienteName; 
	private double checkingAccountBalance;
	private double creditLimit;
	
	public Conta() {
	}
	public Conta(String clienteName, double chekingAccountBalance, double creditLimit) {
		this.clienteName = clienteName;
		this.checkingAccountBalance = chekingAccountBalance;
		this.creditLimit = creditLimit;
	}
	
	public void deposit(double valueToDeposit) throws Exception {
		if(valueToDeposit <= 0) {
			throw new Exception("\"Can't deposit negative or zero value\"");
		}
		
		this.setCheckingAccountBalance(valueToDeposit);
		extract(valueToDeposit, TransferType.DEPOSIT);
	}
	
	public void whitdrawCurrentAccount(double valueToWithdraw) throws Exception {
		if(valueToWithdraw > this.getCheckingAccountBalance() && valueToWithdraw > this.getCreditLimit()) {
			throw new Exception("Can't whithdraw values above your limit. Try again!");
		}
		
		this.setCheckingAccountBalance(this.getCheckingAccountBalance() - valueToWithdraw);
		extract(valueToWithdraw, TransferType.WITHDRAW);
	}
	
	public void extract(double value, TransferType transferType ) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("--------- EXTRACT ---------").append("\n");
		buffer.append("Cliente Name: ").append(this.clienteName).append("\n");
		if(TransferType.DEPOSIT.equals(transferType)) buffer.append("Deposit value: ").append(value).append("\n");
		else buffer.append("Withdraw value: ").append(value).append("\n");
		buffer.append("Balance Account: ").append(this.checkingAccountBalance);
		buffer.append("Credit Limit: ").append(this.creditLimit);
		buffer.append("--------- BYE ---------").append("\n");
		
		System.out.println(buffer.toString());
	}
	
	
	public String getClienteName() {
		return clienteName;
	}
	
	public void setClienteName(String clienteName) {
		this.clienteName = clienteName;
	}
	
	public double getCheckingAccountBalance() {
		return checkingAccountBalance;
	}
	
	public void setCheckingAccountBalance(double checkingAccountBalance) {
		this.checkingAccountBalance = checkingAccountBalance;
	}
	
	public double getCreditLimit() {
		return creditLimit;
	}
	
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
}
