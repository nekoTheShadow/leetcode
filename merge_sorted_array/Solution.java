package merge_sorted_array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        test(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
        test(new int[] {1}, 1, new int[] {}, 0);
        test(new int[] {0}, 0, new int[] {1}, 1);
    }

    public static void test(int[] nums1, int m, int[] nums2, int n) {
        new Solution().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] a = new int[m+n];
        int x = 0;
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            int p = i<m ? nums1[i] : Integer.MAX_VALUE;
            int q = j<n ? nums2[j] : Integer.MAX_VALUE;

            if (p < q) {
                a[x++] = p;
                i++;
            } else {
                a[x++] = q;
                j++;
            }
        }

        System.arraycopy(a, 0, nums1, 0, m+n);
    }
}
