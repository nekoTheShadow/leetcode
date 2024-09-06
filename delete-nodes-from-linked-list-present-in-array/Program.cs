using delete_nodes_from_linked_list_present_in_array;

ListNode CreateList(params int[] vals)
{
    var nodes = vals.Select(val => new ListNode(val)).ToList();
    for (int i = 0; i < nodes.Count - 1; i++)
    {
        nodes[i].next = nodes[i + 1];
    }
    return nodes[0];
}

void PrintList(ListNode head)
{
    var vals = new List<int>();
    while (head != null)
    {
        vals.Add(head.val);
        head = head.next;
    }
    Console.WriteLine(String.Join(",", vals));
}

var s = new Solution();
PrintList(s.ModifiedList(new int[] { 1, 2, 3 }, CreateList(1, 2, 3, 4, 5)));
PrintList(s.ModifiedList(new int[] { 1 }, CreateList(1, 2, 1, 2, 1, 2)));
PrintList(s.ModifiedList(new int[] { 5 }, CreateList(1, 2, 3, 4)));
PrintList(s.ModifiedList(new int[] { 9, 2, 5 }, CreateList(2, 10, 9)));