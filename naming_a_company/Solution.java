package naming_a_company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public long distinctNames(String[] ideas) {
        String[] ascii = "abcdefghijklmnopqrstuvwxyz".split("");
        
        Map<String, Set<String>> map = new HashMap<>();
        for (String key : ascii) {
            map.put(key, new HashSet<>());
        }
        for (String idea : ideas) {
            map.get(idea.substring(0, 1)).add(idea.substring(1));
        }

        long ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i+1; j < 26; j++) {
                Set<String> a = map.get(ascii[i]);
                Set<String> b = map.get(ascii[j]);
                long k = a.stream().filter(x -> b.contains(x)).count();
                ans += 2 * (k-a.size()) * (k-b.size());
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().distinctNames(new String[] {"coffee","donuts","time","toffee"}));
    }
}
