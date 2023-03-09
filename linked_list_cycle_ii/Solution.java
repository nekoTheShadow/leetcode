package linked_list_cycle_ii;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        
        ListNode a = head.next.next;
        ListNode b = head.next;
        while (a!=b) {
            if (a == null || a.next == null || a.next.next == null || b == null || b.next == null) {
                return null;
            }
            a = a.next.next;
            b = b.next;
        }
        
        a = head;
        while (a!=b) {
            a = a.next;
            b = b.next;
        }
        
        return a;
    }
    
    
    public static void main(String[] args) {
        test1();
        test2();
    }
    
    public static void test1() {
        List<ListNode> nodes = IntStream.of(3, 2, 0, -4).mapToObj(ListNode::new).collect(Collectors.toList());
        for (int i = 0; i < nodes.size()-1; i++) {
            nodes.get(i).next = nodes.get(i+1);
        }
        nodes.get(3).next = nodes.get(1);

        ListNode ans = new Solution().detectCycle(nodes.get(0));
        System.out.println(ans);
    }
    
    public static void test2() {
        List<ListNode> nodes = IntStream.of(1,2).mapToObj(ListNode::new).collect(Collectors.toList());
        for (int i = 0; i < nodes.size()-1; i++) {
            nodes.get(i).next = nodes.get(i+1);
        }
        nodes.get(1).next = nodes.get(0);

        ListNode ans = new Solution().detectCycle(nodes.get(0));
        System.out.println(ans);
    }
    
}
