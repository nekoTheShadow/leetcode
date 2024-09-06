namespace delete_nodes_from_linked_list_present_in_array;

public class Solution
{
    public ListNode ModifiedList(int[] nums, ListNode head)
    {
        var set = nums.ToHashSet();

        ListNode root = null;
        ListNode pre = null;
        while (head != null)
        {
            if (!set.Contains(head.val))
            {
                if (root == null)
                {
                    root = pre =  head;
                }
                else
                {
                    pre.next = pre = head;
                }
            }

            (head.next, head) = (null, head.next);
        }
        return root;
    }
}