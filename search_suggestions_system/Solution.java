package search_suggestions_system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
        System.out.println(new Solution().suggestedProducts(new String[] {"havana"}, "havana"));
        System.out.println(new Solution().suggestedProducts(new String[] {"bags","baggage","banner","box","cloths"}, "bags"));
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Map<String, List<String>> dict = new HashMap<>();
        for (String product : products) {
            for (int i = 0; i < product.length(); i++) {
                String prefix = product.substring(0, i+1);
                dict.computeIfAbsent(prefix, unused -> new ArrayList<String>()).add(product);
            }
        }
        
        List<List<String>> rows = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i+1);
            if (dict.containsKey(prefix)) {
                rows.add(dict.get(prefix).stream().limit(3).collect(Collectors.toList()));
            } else {
                rows.add(Collections.emptyList());
            }
        }
        
        return rows;
    }
}
