package count_good_triplets_in_an_array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> v2i = IntStream.range(0, n).boxed().collect(Collectors.toMap(i -> nums2[i], Function.identity()));
        List<Integer> nums = Arrays.stream(nums1).map(num1 -> v2i.get(num1)+1).boxed().collect(Collectors.toList());
        
        BIT l = new BIT(n);
        BIT r = new BIT(n);
        for (int num : nums) {
            r.add(num, 1);
        }
        
        long ans = 0;
        for (int num : nums) {
            long x = l.sum(num-1);
            long y = r.sum(n) - r.sum(num);
            ans += x*y;
            l.add(num, 1);
            r.add(num, -1);
        }
        return ans;
    }
    
    public class BIT {

        private int n;
        private int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n+1];
        }

        public int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += this.tree[i];
                i -= i & -i;
            }
            return s;
        }

        public void add(int i, int x) {
            while (i <= this.n) {
                this.tree[i] += x;
                i += i & -i;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().goodTriplets(new int[] {2,0,1,3}, new int[] {0,1,2,3}));
        System.out.println(new Solution().goodTriplets(new int[] {4,0,1,3,2}, new int[] {4,1,0,2,3}));
    }

}
