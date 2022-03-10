package count_array_pairs_divisible_by_k;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(new int[] {1,2,3,4,5}, 2));
        System.out.println(new Solution().countPairs(new int[] {1,2,3,4}, 5));
    }
    
    public long countPairs(int[] nums, int k) {
        Map<Long, Long> d = Arrays.stream(nums).mapToLong(num -> gcd(num, k)).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long ans = 0;
        for (long p : d.keySet()) {
            for (long q : d.keySet()) {
                if (p <= q && p*q%k==0) {
                    if (p==q) {
                        ans += d.get(p)*(d.get(p)-1)/2;
                    } else {
                        ans += d.get(p)*d.get(q);
                    }
                }
            }
        }
        
        return ans;
    }
    
    public long gcd(long x, long y) {
        if (x < y) {
            long tmp = x;
            x = y;
            y= tmp;
        }

        while (y > 0) {
            long mod = x % y;
            x = y;
            y = mod;
        }

        return x;
    }
}
