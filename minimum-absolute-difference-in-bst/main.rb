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
# @return {Integer}
def get_minimum_difference(root)
    @prev = nil
    @min = Float::INFINITY
    dfs(root)
    @min
end

def dfs(root)
    return if root.nil?
    dfs(root.left)
    @min = [@min, (@prev.val-root.val).abs].min if @prev
    @prev = root
    dfs(root.right)
end
