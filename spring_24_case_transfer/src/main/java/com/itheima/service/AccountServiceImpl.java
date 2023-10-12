package com.itheima.service;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;

    public void transfer(String out, String in, Double money) {
        accountDao.outMoney(out, money);
//        int i = 1/0;
        accountDao.inMoney(in, money);
    }
}
