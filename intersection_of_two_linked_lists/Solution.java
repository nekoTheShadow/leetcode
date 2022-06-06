package intersection_of_two_linked_lists;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA, b = headB;
        while (true) {
            if (a == b) {
                break;
            }

            a = (a==null) ? headB : a.next;
            b = (b==null) ? headA : b.next;
        }
        return a;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
