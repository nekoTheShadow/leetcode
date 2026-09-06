package construct_uniform_parity_array_ii;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
    public boolean uniformArray(int[] nums1) {
        // すべて偶数の場合はtrue
        if (Arrays.stream(nums1).allMatch(num -> num % 2 == 0)) {
            return true;
        }

        // すべて奇数の場合はtrue
        if (Arrays.stream(nums1).allMatch(num -> num % 2 != 0)) {
            return true;
        }

        TreeSet<Integer> evens = Arrays.stream(nums1).filter(num -> num % 2 == 0).boxed().collect(Collectors.toCollection(TreeSet::new));
        TreeSet<Integer> odds = Arrays.stream(nums1).filter(num -> num % 2 != 0).boxed().collect(Collectors.toCollection(TreeSet::new));


        // すべて奇数に揃えたい
        // → すべての偶数について、自分より小さい奇数が存在すればtrue
        // すべて偶数に揃えたい
        // → すべての奇数について、自分より小さい奇数が存在すればtrue （これはありえない）
        return evens.stream().allMatch(even -> odds.lower(even) != null);
    }
}
