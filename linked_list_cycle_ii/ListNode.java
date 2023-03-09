package linked_list_cycle_ii;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
    
    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
