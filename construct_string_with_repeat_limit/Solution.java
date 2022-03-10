package construct_string_with_repeat_limit;

import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().repeatLimitedString("cczazcc", 3));
        System.out.println(new Solution().repeatLimitedString("aababab", 2));
    }
    
    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character, Integer> t = new TreeMap<>();
        for (char ch : s.toCharArray()) {
            t.put(ch, t.getOrDefault(ch, 0)+1);
        }
        
        Character last = '@';
        int count = 1;
        StringBuilder ans = new StringBuilder();
        while (!t.isEmpty()) {
            char ch = t.lastKey();
            if (last == ch) {
                if (repeatLimit == count) {
                    if (t.lowerKey(ch) == null) {
                        break;
                    }
                    ch = t.lowerKey(ch);
                    last = ch;
                    count = 1;
                } else {
                    count++;
                }
            } else {
                last = ch;
                count = 1;
            }
            
            ans.append(ch);
            t.put(ch, t.get(ch)-1);
            if (t.get(ch)==0) {
                t.remove(ch);
            }
        }
        
        return ans.toString();
    }
}
