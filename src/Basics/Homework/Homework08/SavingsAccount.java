package Basics.Homework.Homework08;

/** 扩展前一个联系的BankAccount类，新类SavingsAccount每个月都有
 * 利息产生(earMonthlyInterest方法被调用)，并且有每月
 * 三次免手续费的存款货取款。在earnMonthlyInterest方法中共重置交易计数
*/
public class SavingsAccount extends BankAccount{
    // 新增加属性
    private int count = 3;
    private double rate = 0.01; // 利率

    public void earMonthlyInterest() {
        // 每个月初，我们统计上个月的利息，同时将count = 3
        count = 3;
        super.deposit(getBalance() * rate);
    }

    @Override
    public void deposit(double amount) {
        // 判断是否还可以免手续费
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1); // 1块转入银行
        }
        count--; // 减去一次
    }

    @Override
    public void withdraw(double amount) { // 取款
        // 判断是否还可以免手续费
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1); // 1块转入银行
        }
        count--; // 减去一次
    }

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
