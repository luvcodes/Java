package PhaseOne.Basics.level3.encapsulation;

/**
 * Account类要求具有属性：姓名（长度为2位或3位或4位）、余额（必须>20）
 * 密码（必须是六位），如果不满足，则给出提示信息，并给默认值
 * 通过setXxx的方法给Account的属性赋值
 * 在AccountTest中测试
 */
public class Account {
    // encapsulation
    private String name;
    private int balance;
    private String pwd;

    // 提供两个构造器
    public Account() {}

    public Account(String name, int balance, String pwd) {
        this.setName(name);
        this.setBalance(balance);
        this.setPwd(pwd);
    }


    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("Name length should be 2 or 3 or 4");
            this.name = "Give a name";
        }
    }
    public void setBalance(int balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("Balance should be more than 20");
            this.balance = 0; // default is 0
        }
    }
    public void setPwd(String pwd) {
        if (pwd.length() == 6) {
            this.pwd = pwd;
        } else {
            System.out.println("password must be 6 digits");
            this.pwd = "000000";
        }
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }
    public String getPwd(){
        return pwd;
    }

    // 显示账号信息
    public void showInfo() {
        // 可以增加权限的校验
        System.out.println("account info name = " + name + ", balance = " + balance + ", pwd = " + pwd);
    }
}
