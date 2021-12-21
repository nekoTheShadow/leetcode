package minimum_operations_to_make_the_array_k_increasing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int kIncreasing(int[] arr, int k) {
        int ans = 0;
        for (int s = 0; s < k; s++) {
            long[] a = IntStream.iterate(s, i -> i < arr.length, i -> i + k).mapToLong(i -> arr[i]).toArray();
            long[] b = lis(a, false);
            ans += a.length - b.length;
        }
        return ans;
    }
    
    public long[] lis(long[] a, boolean strict) {
        int n = a.length;
        List<Long> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = strict ? bisectLeft(b, a[i]) : bisectRight(b, a[i]);
            if (b.size() == x) {
                b.add(a[i]);
            } else {
                b.set(x, a[i]);
            }
        }
        return b.stream().mapToLong(Long::longValue).toArray();
    }
    
    public <T> int bisectLeft(List<? extends Comparable<? super T>> a, T x) {
        int ng = -1;
        int ok = a.size();
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a.get(mi).compareTo(x) >= 0) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }
    
    public <T> int bisectRight(List<? extends Comparable<? super T>> a, T x) {
        int ng = -1;
        int ok = a.size();
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a.get(mi).compareTo(x) > 0) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kIncreasing(new int[] {5,4,3,2,1}, 1));
        System.out.println(solution.kIncreasing(new int[] {4,1,5,2,6,2}, 2));
        System.out.println(solution.kIncreasing(new int[] {4,1,5,2,6,2}, 3));
    }
}
