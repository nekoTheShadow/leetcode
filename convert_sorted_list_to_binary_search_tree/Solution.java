package convert_sorted_list_to_binary_search_tree;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        return f(head, null);
    }
    
    public TreeNode f(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) {
            return null;
        }
        
        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }

        return new TreeNode(slow.val, f(head, slow), f(slow.next, tail));
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}


