package kth_missing_positive_number;

public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int x = 1;
        while (true) {
            if (i < arr.length && arr[i] == x) {
                i++;
            } else {
                if (k==1) {
                    break;
                }
                k--;
            }
            x++;
        }
        return x;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findKthPositive(new int[] {2,3,4,7,11}, 5));
        System.out.println(new Solution().findKthPositive(new int[] {1,2,3,4}, 2));
    }
}
