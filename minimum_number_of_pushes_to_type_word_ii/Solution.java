package minimum_number_of_pushes_to_type_word_ii;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int minimumPushes(String word) {
        Map<Integer, Integer> counter = word.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        List<Integer> chars = IntStream.rangeClosed('a', 'z').boxed().sorted(Comparator.comparing(x -> counter.getOrDefault(x, 0)).reversed()).collect(Collectors.toList());
        return IntStream.range(0, chars.size()).map(i -> (i/8+1) * counter.getOrDefault(chars.get(i), 0)).sum();
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().minimumPushes("abcde")); // 5
		System.out.println(new Solution().minimumPushes("xyzxyzxyzxyz")); // 12
		System.out.println(new Solution().minimumPushes("aabbccddeeffgghhiiiiii")); // 24
	}
}
