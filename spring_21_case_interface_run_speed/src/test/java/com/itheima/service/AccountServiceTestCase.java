package com.itheima.service;

import java.util.List;
import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfig.class)
public class AccountServiceTestCase {
    @Autowired
    private AccountService accountService;

    @Test
    public void testFindById() {
        Account ac = accountService.findById(2);
        System.out.println(ac);
    }

    @Test
    public void testFindAll() {
        List<Account> all = accountService.findAll();
        System.out.println(all);
    }
}
