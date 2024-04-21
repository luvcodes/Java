```Java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfig.class)

public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void testFindById() {
        System.out.println(accountService.findById(2));
    }
}
```