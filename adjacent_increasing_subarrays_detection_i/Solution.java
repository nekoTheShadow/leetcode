package adjacent_increasing_subarrays_detection_i;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] d = new int[n];

        int right = 0;
        Deque<Integer> q = new ArrayDeque<>();
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

        for (int i = 0; i < n - k; i++) {
            int j = i + k;
            if (d[i] >= k && d[j] >= k) {
                return true;
            }
        }
        return false;
    }

}