package com.roger.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.roger.shop.BaseTestCase;
import com.roger.shop.model.Account;
import com.roger.shop.service.AccountService;

public class AccountServiceImplTest extends BaseTestCase {

	@Resource(name = "accountService")
	private AccountService accountService;

	@Test
	public void testSave() {
		Account account = new Account();
		account.setLogin("Mary");
		account.setName("玛丽");
		account.setPassword("Mary");
		accountService.save(account);
	}
	
	@Test
	public void testFindAll() {
		List<Account> accounts = accountService.findAll();
		for (Account account : accounts) {
			System.out.println(account);
		}
	}

}
