package find_first_palindromic_string_in_the_array;

import java.util.Arrays;

public class Solution {
    public String firstPalindrome(String[] words) {
        return Arrays.stream(words).filter(word -> new StringBuilder(word).reverse().toString().equals(word)).findFirst().orElse("");
    }
}
