package count_all_valid_pickup_and_delivery_options;

public class Solution {
    public int countOrders(int n) {
        // (2*n)! / 2^n
        long numer = modFact(2*n);
        long denom = modPow(2, n);
        return (int)(numer * modInv(denom) % MOD);
    }

    private long MOD = 1000000000 + 7;

    private long modPow(long x, long y) {
        long z = 1;
        while (y > 0) {
            if (y%2 == 0) {
                x = (x * x) % MOD;
                y /= 2;
            } else {
                z = (z * x) % MOD;
                y--;
            }
        }
        return z;
    }

    private long modInv(long x) {
        return modPow(x, MOD-2);
    }

    private long modFact(long x) {
        long sum = 1;
        for (long i = 1; i <= x; i++) {
            sum *= i;
            sum %= MOD;
        }
        return sum;
    }
}
