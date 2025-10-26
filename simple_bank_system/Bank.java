package simple_bank_system;

public class Bank {
    private final long[] balance;

    public Bank(long[] balance) {
        int n = balance.length;
        long[] newBalance = new long[n + 1];
        System.arraycopy(balance, 0, newBalance, 1, n);
        this.balance = newBalance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!exists(account1)) {
            return false;
        }
        if (!exists(account2)) {
            return false;
        }
        if (balance[account1] < money) {
            return false;
        }
        balance[account1] -= money;
        balance[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!exists(account)) {
            return false;
        }
        balance[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!exists(account)) {
            return false;
        }
        if (balance[account] < money) {
            return false;
        }
        balance[account] -= money;
        return true;
    }

    private boolean exists(int account) {
        return 1 <= account && account < balance.length;
    }
}