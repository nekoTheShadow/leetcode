package number_of_smooth_descent_periods_of_a_stock;

public class Solution {
    public long getDescentPeriods(int[] prices) {
        int ptr = 0;
        int n = prices.length;
        long ans = 0;
        while (ptr < n) {
            long count = 1;
            while (ptr < n-1 && prices[ptr]-1 == prices[ptr+1]) {
                ptr++;
                count++;
            }
            
            ans += count*(count-1)/2 + count;
            ptr++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getDescentPeriods(new int[] {3,2,1,4})); //=> 7
        System.out.println(new Solution().getDescentPeriods(new int[] {8,6,7,7})); //=> 4
        System.out.println(new Solution().getDescentPeriods(new int[] {1})); //=> 1
    }
}
