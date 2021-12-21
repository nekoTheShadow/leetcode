package adding_spaces_to_a_string;

public class Solution {
    public String addSpaces(String s, int[] spaces) {
        int start = 0;
        int n = spaces.length;
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < n; i++) {
            t.append(s.substring(start, spaces[i]));
            t.append(" ");
            start = spaces[i];
        }
        t.append(s.substring(spaces[n-1], s.length()));
        return t.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().addSpaces("LeetcodeHelpsMeLearn", new int[] {8,13,15}));
        System.out.println(new Solution().addSpaces("icodeinpython", new int[] {1,5,7,9}));
        System.out.println(new Solution().addSpaces("spacing", new int[] {0,1,2,3,4,5,6}));
    }
}
