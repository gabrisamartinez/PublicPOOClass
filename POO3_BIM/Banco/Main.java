package com.univille.gabrielly.banco;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Conta conta = new Conta();
		conta.setCreditLimit(100.0);
		
		int answer = 1;
		System.out.println("Hello! Wellcome to GGMBank, please enter your name to create your new account: ");
		conta.setClienteName(scanner.nextLine());
		while(answer != 0) {
			System.out.println("Hello " + conta.getClienteName() + "! Your account just been created, tell us, what"
					+ "you want to do? \n"
					+ "1.Deposit\n"
					+ "2.Whithdraw");
			answer = scanner.nextInt();
			
			if(answer != 0 && TransferType.DEPOSIT.equals(answer)) {
				System.out.println("Ok, tell us, what value you want deposit? ");
				double valueToDeposit = scanner.nextDouble();
				conta.deposit(valueToDeposit);
			} else if(answer != 0) {
				System.out.println("Ok, tell us, what value you want deposit? ");
				double valueToDeposit = scanner.nextDouble();
				conta.deposit(valueToDeposit);
			}
		}
	}
}
