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
def find_mode(root)
    cur = root
    
    ans = []
    cur_count = 0
    cur_val = 0
    max_count = 0


    while cur
        if cur.left
            leftchild = cur.left
            rightmost = cur.left
            while rightmost.right
                rightmost = rightmost.right
            end
            rightmost.right = cur
            cur.left = nil
            cur = leftchild
        else
            if cur_val == cur.val
                cur_count += 1
            else
                cur_count = 1
                cur_val = cur.val
            end

            if cur_count > max_count
                ans = []
                max_count = cur_count
            end
            if cur_count == max_count
                ans << cur.val
            end

            cur = cur.right
        end
    end

    ans
end
