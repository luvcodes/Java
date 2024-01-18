package Thread.ThreadSynchronize_5.sync_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
    }

    /**
     * Transfers money from one account to another.
     * */
    public void transfer(int from, int to, double amount){
        bankLock.lock();
        try {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * Gets the sum of all account balances
     * */
    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    /**
     * Gets the number of accounts in the bank
     * */
    public int size() {
        return accounts.length;
    }
}
