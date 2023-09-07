package com.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entitys.Account;
import com.spring.repository.IAccountRepository;
import com.spring.service.AccountService;


@Service
public class IAccountService implements AccountService{
	
	@Autowired
	private HashPassword hashPassword;
	@Autowired
	private IAccountRepository repo;
	
	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
			Account acc = repo.getByUsername(account.getUsername());
			acc.setEmail(account.getEmail());
			acc.setPassword(HashPassword.hash(account.getPassword()));
			acc.setRole(account.getRole());
			return repo.save(acc);
	}

	@Override
	public Account authention(String username, String password) {

		Account account = repo.getByUsername(username);
	
		if (account == null) {
			return null;
		}
		if(HashPassword.check(password, account.getPassword()) == false) {
			return null;
		}
		return account;
	}



}
