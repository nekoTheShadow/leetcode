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
def max_level_sum(root)
    nodes = [root]
    lvl = 1
    max_sum = -Float::INFINITY
    max_lvl = -1

    until nodes.empty?
        sum = nodes.sum(&:val)
        max_lvl, max_sum = lvl, sum if max_sum < sum
        
        nodes = nodes.flat_map{[_1.left, _1.right]}.compact
        lvl += 1
    end

    max_lvl
end
