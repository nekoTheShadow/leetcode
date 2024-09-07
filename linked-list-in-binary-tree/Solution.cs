namespace linked_list_in_binary_tree;

public class Solution
{
    public bool IsSubPath(ListNode head, TreeNode root)
    {
        if (root == null)
        {
            return false;
        }
        return Check(head, root) || IsSubPath(head, root.left) || IsSubPath(head, root.right);
    }

    public bool Check(ListNode head, TreeNode root)
    {
        if (head == null)
        {
            return true;
        }
        if (root == null)
        {
            return false;
        }
        return head.val == root.val && (Check(head.next, root.left) || Check(head.next, root.right));
    }
}