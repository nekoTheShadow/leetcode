package check_if_a_parentheses_string_can_be_valid;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n%2 != 0) {
            return false;
        }
        
        int wild1 = 0;
        int fixed1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')' && locked.charAt(i) == '1') {
                fixed1++;
            } else {
                wild1++;
            }
            
            if (wild1 < fixed1) {
                return false;
            }
        }
        
        int wild2 = 0;
        int fixed2 = 0;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '(' && locked.charAt(i) == '1') {
                fixed2++;
            } else {
                wild2++;
            }
            
            if (wild2 < fixed2) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canBeValid("))()))", "010100")); //=> true
        System.out.println(new Solution().canBeValid("()()", "0000")); //=> true
        System.out.println(new Solution().canBeValid(")", "0")); //=> true
    }
}
