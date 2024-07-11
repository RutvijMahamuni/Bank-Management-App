package com.bankapp.service;

import com.bankapp.model.Account;

public interface Rbi {
	public void createAccount();
	public void dispAllDetails(Account a);
	public void deposit(Account a);
	public void withdrawal(Account a);
	public void balancechk(Account a);
}
