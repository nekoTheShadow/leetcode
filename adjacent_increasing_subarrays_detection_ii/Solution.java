package adjacent_increasing_subarrays_detection_ii;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int right = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int[] d = new int[n];
        for (int left = 0; left < n; left++) {
            while (right < n && (q.isEmpty() || q.peekLast() < nums.get(right))) {
                q.addLast(nums.get(right));
                right++;
            }
            d[left] = q.size();
            if (left == right) {
                right++;
            } else {
                q.removeFirst();
            }
        }

        int ok = 0;
        int ng = n;
        while (Math.abs(ok - ng) > 1) {
            int mi = (ok + ng) / 2;

            boolean check = false;
            for (int i = 0; i < n - mi; i++) {
                if (d[i] >= mi && d[i + mi] >= mi) {
                    check = true;
                    break;
                }
            }

            if (check) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }
}
