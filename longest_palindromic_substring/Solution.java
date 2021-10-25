package longest_palindromic_substring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new Solution().longestPalindrome(stdin.readLine()));      
    }
    
    public String longestPalindrome(String s) {
        return longestPalindrome(s, '#');
    }
    
    public String longestPalindrome(String s, char dummy) {
        char[] t = new char[s.length()*2+1];
        for (int i = 0; i < s.length(); i++) {
            t[i*2] = dummy;
            t[i*2+1] = s.charAt(i);
        }
        t[t.length-1] = dummy;
        int[] palindromeRadii = new int[t.length];
        
        int center = 0;
        int radius = 0;
        while (center < t.length) {
            while (center-(radius+1) >= 0 && center+(radius+1) < t.length && t[center-(radius+1)] == t[center+(radius+1)]) {
                radius++;
            } 
            
            palindromeRadii[center] = radius;
            
            int oldCenter = center;
            int oldRadius = radius;
            center++;
            radius = 0;
            while (center <= oldCenter + oldRadius) {
                int mirroredCenter = oldCenter - (center - oldCenter);
                int maxMirroredRadius = oldCenter + oldRadius - center;
                if (palindromeRadii[mirroredCenter] < maxMirroredRadius) {
                    palindromeRadii[center] = palindromeRadii[mirroredCenter];
                    center++;
                } else if (palindromeRadii[mirroredCenter] > maxMirroredRadius) {
                    palindromeRadii[center] = maxMirroredRadius;
                    center++;
                } else {
                    radius = maxMirroredRadius;
                    break;
                }
            }
        }
        
        int pivot = 0;
        for (int i = 1; i < palindromeRadii.length; i++) {
            if (palindromeRadii[pivot] < palindromeRadii[i]) {
                pivot = i;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = pivot-palindromeRadii[pivot]+1; i < pivot+palindromeRadii[pivot]; i++) {
            if (t[i] != dummy) {
                ans.append(t[i]);
            }
        }
        
        return ans.toString();
    }
}
