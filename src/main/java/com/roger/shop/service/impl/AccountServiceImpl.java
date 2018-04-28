package com.roger.shop.service.impl;

import org.springframework.stereotype.Service;

import com.roger.shop.model.Account;
import com.roger.shop.service.AccountService;

@Service(value = "accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

}
