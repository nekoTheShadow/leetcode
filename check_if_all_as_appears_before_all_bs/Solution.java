package check_if_all_as_appears_before_all_bs;

import java.util.regex.Pattern;

public class Solution {
    public boolean checkString(String s) {
        // 最後のAが最初のBより前にあるかどうか
        return Pattern.matches("^a+$", s) || s.lastIndexOf("a") < s.indexOf("b");  
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkString("aaabbb"));
        System.out.println(new Solution().checkString("abab"));
        System.out.println(new Solution().checkString("bbb"));
        System.out.println(new Solution().checkString("a"));
    }
}
