package remove_palindromic_subsequences;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removePalindromeSub("ababa"));
        System.out.println(new Solution().removePalindromeSub("abb"));
        System.out.println(new Solution().removePalindromeSub("baabb"));
    }

    // sが回文の場合は明らかに1
    // sが回文ではない場合は、aを除去→bを除去の順で処理可能。よって2
    public int removePalindromeSub(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return s.equals(t) ? 1 : 2;
    }

}
