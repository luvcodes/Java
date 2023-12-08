package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 开启MVC虚拟调用
@AutoConfigureMockMvc
public class WebTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void test() {}

    @Test
    void testWeb() throws Exception {
        // http://localhost:8080/books
        // 创建虚拟请求，当前访问的是/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 然后执行对应的请求
        ResultActions action = mvc.perform(builder);
    }

    /**
     * 如果想验证是否失败，就更改/books这里，改成/books1即可
     * 目标: 匹配执行结果 (是否为预期值)。设定预期值，与真实值进行比较，成功 测试通过，失败 测试失败
     * */
    @Test
    void testStatus() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder); // 实际值

        // 定义执行结果匹配器
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 定义本次调用的预期值，预计本次调用成功的: 状态200
        ResultMatcher ok = status.isOk();

        // 使用本次真实执行结果与预期结果进行比对
        action.andExpect(ok);
    }

    /**
     * 如果想验证是否失败，就更改springboot字符串这里，改成其他string即可
     * 目标: 匹配执行结果 (是否为预期值)。设定预期值，与真实值进行比较，成功 测试通过，失败 测试失败
     * */
    @Test
    void testBody() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder); // 实际值

        // 定义执行结果匹配器
        ContentResultMatchers content = MockMvcResultMatchers.content();
        // 定义预期执行结果
        // 这里是查看预期值的请求体的内容是否与实际值匹配。在BookController里返回的是Springboot
        ResultMatcher result = content.string("springboot");

        // 使用本次真实执行结果与预期结果进行比对
        action.andExpect(result);
    }

    @Test
    void testJson() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder); // 实际值

        // 定义执行结果匹配器
        ContentResultMatchers content = MockMvcResultMatchers.content();
        // 定义预期执行结果
        ResultMatcher json = content.json("{\"id\":1,\"name\":\"Spring Boot\",\"type\":\"IT\",\"description\":\"SpringBoot开发\"}");

        // 使用本次真实执行结果与预期结果进行比对
        action.andExpect(json);
    }

    @Test
    void testContetType() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder); // 实际值

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");

        action.andExpect(contentType);
    }

    @Test
    void testGetById() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder); // 实际值

        // 测状态码
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        action.andExpect(ok);

        // 测结果
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json("{\"id\":1,\"name\":\"Spring Boot\",\"type\":\"IT\",\"description\":\"SpringBoot开发\"}");
        action.andExpect(json);

        // 测请求头
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        action.andExpect(contentType);
    }
}
