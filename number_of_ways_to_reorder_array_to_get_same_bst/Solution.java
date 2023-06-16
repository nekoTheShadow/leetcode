package number_of_ways_to_reorder_array_to_get_same_bst;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    private ModuloNCR ncr;
    private static long mod = 1000000000+7;
    
    public int numOfWays(int[] nums) {
        this.ncr = new ModuloNCR(nums.length, mod);
        return (int)((dfs(Arrays.stream(nums).mapToLong(num -> (long)num).toArray())-1)%mod);
    }
    
    private long dfs(long[] nums) {
        int m = nums.length;
        if (m<3) {
            return 1;
        }
        
        long[] l = Arrays.stream(nums).filter(num -> num<nums[0]).toArray();
        long[] r = Arrays.stream(nums).filter(num -> num>nums[0]).toArray();
        
        long ret = 1;
        ret *= dfs(l);
        ret %= mod;
        ret *= dfs(r);
        ret %= mod;
        ret *= ncr.nCr(m-1, l.length);
        ret %= mod;
        return ret;
    }
    
    public class ModuloNCR {
        private long[] f;
        private long[] g;
        private long mod;
        
        public ModuloNCR(int n, long mod) {
            this.mod = mod;
            
            f = new long[n+1];
            g = new long[n+1];
            f[0] = f[1] = 1;
            g[0] = g[1] = 1;
            
            for (int i = 2; i <= n; i++) {
                f[i] = f[i-1]*i%mod;
                g[i] = BigInteger.valueOf(f[i]).modInverse(BigInteger.valueOf(mod)).longValue();
            }
        }
        
        public long nCr(int n, int r) {
            return f[n]*(g[r]*g[n-r]%mod)%mod;
        }
    }
}
