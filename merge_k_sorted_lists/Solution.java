package merge_k_sorted_lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.function.Predicate;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(list -> list.val));
        Arrays.stream(lists).filter(Predicate.not(Objects::isNull)).forEach(pq::add);
        while (!pq.isEmpty()) {
            ListNode list = pq.remove();
            
            if (head == null) {
                head = list;
                tail = list;
            } else {
                tail.next = list;
                tail = tail.next;
            }
            
            if (list.next != null) {
                pq.add(list.next);
            }
        }
        
        return head;
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
