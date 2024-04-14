package com.itheima.mp.service;

import com.itheima.mp.domain.po.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IAddressServiceTest {

    @Autowired
    private IAddressService addressService;

    @Test
    void testQuery() {
        List<Address> list = addressService.list();

        list.forEach(System.out::println);
    }
}