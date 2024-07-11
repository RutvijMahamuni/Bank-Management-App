package com.bankapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bankapp.model.Account;
import com.bankapp.service.Rbi;

public class Sbi implements Rbi {
	List<Account> acclist = new ArrayList<>();
	int acno = 1000;
	Scanner sc = new Scanner(System.in);

	public Account searchAcc(int acno) {
		Account ac = null;
		for (Account a : acclist) {
			if (acno == a.getAccNo()) {
				ac = a;
			}
		}
		return ac;
	}

	@Override
	public void createAccount() {
		System.out.println("************");
		System.out.println("Enter name: ");
		String nm = sc.next();
		System.out.println("Enter mob no:");
		String mno = sc.next();
		System.out.println("Enter Adhar No: ");
		String adhno = sc.next();
		System.out.println("Enter gender: ");
		String gender = sc.next();
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		System.out.println("Enter balance: ");
		double bal = sc.nextDouble();
		Account a = new Account();
		acno = acno + 1;
		a.setAccNo(acno);
		a.setName(nm);
		a.setMobNo(mno);
		a.setAdharNo(adhno);
		a.setGender(gender);
		a.setAge(age);
		a.setBalance(bal);
		acclist.add(a);
		System.out.println("************");
		System.out.println("New account created successfully!");
		System.out.println("Your account number is: " + a.getAccNo());
		System.out.println("************");
	}

	@Override
	public void dispAllDetails(Account a) {
		System.out.println("************");
		System.out.println(a);
		System.out.println("************");
	}

	@Override
	public void deposit(Account a) {
		System.out.println("************");
		System.out.println("Enter the amount to deposit: ");
		double amt = sc.nextInt();
		double bal = a.getBalance();
		bal = bal + amt;
		a.setBalance(bal);
		System.out.println("Amount deposited successfully!");
		System.out.println("************");

	}

	@Override
	public void withdrawal(Account a) {
		System.out.println("************");
		System.out.println("Enter the amount to withdraw: ");
		double amt = sc.nextInt();
		double bal = a.getBalance();
		if (amt > bal) {
			System.out.println("Insufficient funds!");
		} else {
			bal = bal - amt;
			a.setBalance(bal);
			System.out.println("Amount withdrawn successfully!");
		}
		System.out.println("************");

	}

	@Override
	public void balancechk(Account a) {
		System.out.println("************");
		System.out.println("Your current balance is: " + a.getBalance());
		System.out.println("************");

	}

}
