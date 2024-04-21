# 整合流程

1. 创建工程
2. SSM整合
    1. Spring
        1. SpringConfig
    2. MyBatis
        1. MyBatisConfig
        2. JdbcConfig
        3. jdbc.properties
    3. SpringMVC
        1. ServletConfig
        2. SpringMvcConfig
3. 功能模块
    1. 表与实体类
    2. DAO (接口 + 自动代理)
    3. Service (接口 + 实现类)
        1. 业务层接口测试 (整合JUnit)
    4. Controller
        1. 表现层接口测试 (Postman)

# 表现层数据封装

### 设置统一数据返回结果类

```Java
public class Result {
	private Object data;
    private Integer Code;
    private String msg;
}
```

### 设置统一数据返回结果编码

```Java
public static final Integer SAVE_OK = 20011;
public static final Integer DELETE_OK = 20021;
public static final Integer UPDATE_OK = 20031;
public static final Integer GET_OK = 20041;

public static final Integer SAVE_ERR = 20010;
public static final Integer DELETE_ERR = 20020;
public static final Integer UPDATE_ERR = 20030;
public static final Integer GET_ERR = 20040;
```

### 根据情况设定合理的Result

```Java

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean save = bookService.save(book);
        return new Result(save ? Code.SAVE_OK : Code.SAVE_ERR, save);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean update = bookService.update(book);
        return new Result(update ? Code.UPDATE_OK : Code.UPDATE_ERR, update);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean delete = bookService.delete(id);
        return new Result(delete ? Code.DELETE_OK : Code.DELETE_ERR, delete);
    }

    @GetMapping("/{id}")
    public Result getBookById(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "" : "数据查询失败，请重试！";

        return new Result(code, book, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "" : "数据查询失败，请重试！";

        return new Result(code, bookList, msg);
    }
}
```

# 异常处理器

```Java
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception) {
        System.out.println("异常捕捉");
        return new Result(666, null, "异常捕捉");
    }
}
```