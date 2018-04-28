package com.roger.shop.service.impl;

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
		account.setLogin("admin");
		account.setName("小强");
		account.setPassword("admin");
		accountService.save(account);
	}

}
