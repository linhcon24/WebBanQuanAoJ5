package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.entitys.Account;


public interface AccountService {
	
	public Account update(Account account);
	public Account authention(String username , String password);
}
