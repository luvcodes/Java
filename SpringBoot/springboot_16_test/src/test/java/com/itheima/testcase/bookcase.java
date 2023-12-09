package com.itheima.testcase;

import com.itheima.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class bookcase {
    @Autowired
    private BookCase bookCase;

    @Test
    void testBookCase() {
        System.out.println(bookCase);
    }
}
