namespace create_binary_tree_from_descriptions;

public class Solution
{
    public TreeNode CreateBinaryTree(int[][] descriptions)
    {
        var dict = new Dictionary<int, TreeNode>();
        foreach (var description in descriptions)
        {
            var parent = description[0];
            var child = description[1];
            var isleft = description[2];

            if (!dict.ContainsKey(parent))
            {
                dict[parent] = new TreeNode(parent);
            }
            if (!dict.ContainsKey(child))
            {
                dict[child] = new TreeNode(child);
            }

            if (isleft == 1)
            {
                dict[parent].left = dict[child];
            }
            else
            {
                dict[parent].right = dict[child];
            }
        }

        return dict[descriptions.Select(description => description[0]).Except(descriptions.Select(description => description[1])).Single()];
    }
}
