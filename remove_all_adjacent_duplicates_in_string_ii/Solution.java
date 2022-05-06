package remove_all_adjacent_duplicates_in_string_ii;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates("abcd", 2));
        System.out.println(sol.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(sol.removeDuplicates("pbbcggttciiippooaais", 2));
    }
    
    public String removeDuplicates(String s, int k) {
        Deque<Tuple> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast().ch == ch) {
                stack.peekLast().count++;
            } else {
                Tuple t = new Tuple();
                t.ch = ch;
                t.count = 1;
                stack.addLast(t);
            }
            
            if (stack.peekLast().count == k) {
                stack.removeLast();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Tuple t = stack.removeFirst();
            for (int i = 0; i < t.count; i++) {
                sb.append(t.ch);
            }
        }
        
        return sb.toString();
    }
    
    public static class Tuple {
        char ch;
        long count;
    }
}
