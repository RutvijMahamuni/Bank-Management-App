package com.bankapp.client;

import java.util.Scanner;

import com.bankapp.model.Account;
import com.bankapp.serviceImpl.Sbi;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sbi s = new Sbi();
		Account a = null;
		boolean flag1 = true;
		while (flag1) {
			System.out.println("\n--WELCOME TO THE BANK APP--\n" + "Please select an option:\n"
					+ "1. Create new account\n" + "2. Access existing account\n");
			int sel = sc.nextInt();
			if (sel == 1) {
				s.createAccount();
			} else if (sel == 2) {
				System.out.println("Enter your account number: ");
				int acno = sc.nextInt();
				a=s.searchAcc(acno);
				if (a != null) {
					boolean flag2 = true;
					while (flag2) {
						System.out.println("\t--WELCOME, " + a.getName() + "--");
						System.out.println();
						System.out.println("Please enter your choice");
						System.out.println("1. Check balance\n" + "2. Withdraw amount\n" + "3. Deposit amount\n"
								+ "4. Display account details\n" + "0. Exit\n");
						int ch = sc.nextInt();

						switch (ch) {
						case 1:
							s.balancechk(a);
							break;
						case 2:
							s.withdrawal(a);
							break;
						case 3:
							s.deposit(a);
							break;
						case 4:
							s.dispAllDetails(a);
							break;
						case 0:
							System.out.println("Have a great day ahead "+a.getName()+"!");
							flag2 = false;
							break;
						}
					}
				} else {
					System.err.println("Account not found! Please try again!");
				}
			}
		}
	}
}
