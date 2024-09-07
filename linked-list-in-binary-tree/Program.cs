using linked_list_in_binary_tree;

ListNode CreateList(params int[] vals)
{
    var nodes = vals.Select(val => new ListNode(val)).ToList();
    for (int i = 0; i < nodes.Count - 1; i++)
    {
        nodes[i].next = nodes[i + 1];
    }
    return nodes[0];
}
TreeNode CreateTree(params int[] vals)
{
    var nodes = vals.Select(val => val == -1 ? null : new TreeNode(val)).ToList();
    int n = nodes.Count;
    for (int i = 0; i < n; i++)
    {
        if (nodes[i] == null)
        {
            continue;
        }
        if (2 * i + 1 < n)
        {
            nodes[i].left = nodes[2 * i + 1];
        }
        if (2 * i + 2 < n)
        {
            nodes[i].right = nodes[2 * i + 2];
        }
    }
    return nodes[0];
}

var root = CreateTree(
1,
4, 4,
-1, 2, 2, -1,
-1, -1, 1, -1, 6, 8, -1, -1
- 1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, 3
);

var s = new Solution();
Console.WriteLine(s.IsSubPath(CreateList(4, 2, 8), root));
Console.WriteLine(s.IsSubPath(CreateList(1, 4, 2, 6), root));
Console.WriteLine(s.IsSubPath(CreateList(1, 4, 2, 6, 8), root));
