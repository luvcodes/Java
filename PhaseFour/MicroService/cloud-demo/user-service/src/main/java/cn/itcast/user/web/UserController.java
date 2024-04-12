package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ryanw
 */
@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope // 实现配置热更新的第一种方式
public class UserController {
    @Autowired
    private UserService userService;

    // 有了PatternProperties就可以替代这个了
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @Autowired
    private PatternProperties patternProperties;

    @GetMapping("prop")
    public PatternProperties prop() {
        return patternProperties;
    }

    @GetMapping("now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }

    /**
     * 路径： /user/110
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id, @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("truth: " + truth);
        return userService.queryById(id);
    }
}
