package palindromic_substrings;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("abc"));
        System.out.println(new Solution().countSubstrings("aaa"));
    }
    
    public int countSubstrings(String s) {
        List<String> words = manachersAlgorithm(s, '#');
        int ans = 0;
        for (String word : words) {
            int len = word.length();
            if (len % 2 == 0) {
                ans += len / 2;
            } else {
                ans += len / 2 + 1;
            }
        }
        return ans;
    }

    /**
     * https://snuke.hatenablog.com/entry/2014/12/02/235837
     * すべてのiについて、S[i]を中心とする最長の回文を格納する (文字列長偶数と文字列長奇数両方に対応している)
     */
    public List<String> manachersAlgorithm(String s, char dummy) {
        int n = s.length();
        char[] c = new char[n*2-1];
        for (int i = 0; i < n; i++) {
            c[i*2] = s.charAt(i);
            if (i != n-1) {
                c[i*2+1] = dummy;
            }
        }
        
        int l = c.length;
        int[] r = new int[l];
        int i = 0;
        int j = 0;
        while (i < l) {
            while (i-j>=0 && i+j<l && c[i-j]==c[i+j]) {
                j++;
            }
            r[i] = j;
            int k = 1;
            while (i-k>=0 && k+r[i-k]<j) {
                r[i+k] = r[i-k];
                k++;
            }
            i += k;
            j -= k;
        }
        
        List<String> ans = new ArrayList<>();
        for (int x = 0; x < l; x++) {
            StringBuilder sb = new StringBuilder();
            for (int y = x-r[x]+1; y < x+r[x]; y++) {
                if (y%2==0) {
                    sb.append(c[y]);
                }
            }
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
