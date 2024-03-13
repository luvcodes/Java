package encapsulation;

/**
 * @author ryanw
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account();
        account1.setName("jack");
        account1.setBalance(6);
        account1.setPwd("123456");
        account1.showInfo();

        Account account2 = new Account("jack", 60, "123456");
        account2.showInfo();
    }
}
