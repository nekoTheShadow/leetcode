# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {TreeNode} root
# @return {Integer[]}
def largest_values(root)
    maxs = []
    dfs(root, 0, maxs)
    maxs
end

def dfs(node, index, maxs)
    return node if node.nil?

    if maxs[index].nil?
        maxs[index] = node.val
    else
        maxs[index] = [maxs[index], node.val].max
    end

    dfs(node.left,  index+1, maxs)
    dfs(node.right, index+1, maxs)
end
