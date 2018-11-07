package com.bose.reconcile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataReconciler {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public void reconcileData() {
		
	}
	
	private void reconcileCustomers() {
		
		List<Account> accounts = accountRepository.getAccountsToReconcile();
		for (Account account : accounts) {
		}
	}
}
