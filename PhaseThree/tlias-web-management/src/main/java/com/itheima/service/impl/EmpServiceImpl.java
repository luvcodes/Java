package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ryanw
 */
@Slf4j
@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpMapper empMapper;
}
