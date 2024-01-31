package Thread.ThreadSynchronize_5.sync_;

public class TransferRunnable implements Runnable{
    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    /**
     * Constructs a transfer runnable
     * */
    public TransferRunnable(Bank b, int from, double max){
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread is over");
        System.exit(0); //结束程序，但是不会导致程序结束，因为程序还在运行。
        System.out.println("Thread is over"); //这个代码不会执行，因为程序已经结束。
    }
}
