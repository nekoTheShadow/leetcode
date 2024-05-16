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
# @return {Boolean}
def evaluate_tree(root)
    if root.val == 0
        false
    elsif root.val == 1
        true
    elsif root.val == 2
        evaluate_tree(root.left) || evaluate_tree(root.right)
    else
        evaluate_tree(root.left) && evaluate_tree(root.right)
    end
end
