package construct_uniform_parity_array_i;

import java.util.stream.IntStream;

public class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        boolean[] even = new boolean[n];
        boolean[] odd = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 == 0) {
                even[i] = true;
            } else {
                odd[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if ((nums1[i] - nums1[j]) % 2 == 0) {
                    even[i] = true;
                } else {
                    odd[i] = true;
                }
            }
        }

        return IntStream.range(0, n).allMatch(i -> even[i]) || IntStream.range(0, n).allMatch(i -> odd[i]);
    }
}
