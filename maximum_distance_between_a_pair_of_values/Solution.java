package maximum_distance_between_a_pair_of_values;

public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int ret = 0;
        for (int i = 0; i < Math.min(len1, len2); i++) {
            int ok = i - 1;
            int ng = nums2.length;
            while (Math.abs(ok - ng) > 1) {
                int mi = (ok + ng) / 2;
                if (nums2[mi] >= nums1[i]) {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }

            if (i <= ok && ok < nums2.length && nums1[i] <= nums2[ok]) {
                ret = Math.max(ret, ok - i);
            }
        }
        return ret;
    }
}
