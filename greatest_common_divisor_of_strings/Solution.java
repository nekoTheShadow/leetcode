package greatest_common_divisor_of_strings;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().gcdOfStrings("ABCABC","ABC"));
        System.out.println(new Solution().gcdOfStrings("ABABAB","ABAB"));
        System.out.println(new Solution().gcdOfStrings("LEET","CODE"));
    }
    
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        
        String ans = "";
        for (int i = 0, len = str1.length(); i < len; i++) {
            String t = str1.substring(0, i+1);
            if (isOK(str1, t) && isOK(str2, t)) {
                ans = t;
            }
        }
        
        return ans;
    }
    
    public boolean isOK(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if (m%n!=0) {
            return false;
        }
        
        for (int i = 0; i < m; i += n) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i+j) != t.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
