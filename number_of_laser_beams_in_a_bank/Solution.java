package number_of_laser_beams_in_a_bank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int numberOfBeams(String[] bank) {
        int[] counts = Arrays.stream(bank).mapToInt(s -> s.replaceAll("0", "").length()).filter(i -> i > 0).toArray();
        int ans = IntStream.range(0, counts.length-1).map(i -> counts[i]*counts[i+1]).sum();
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBeams(new String[] {"011001","000000","010100","001000"}));
        System.out.println(new Solution().numberOfBeams(new String[] {"000","111","000"}));
    }
}
