# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end
# @param {TreeNode} root
# @param {TreeNode} target
# @param {Integer} k
# @return {Integer[]}
def distance_k(root, target, k)
    @g = Hash.new{|hash, key| hash[key] = []}
    build_graph(root, nil)
    
    @k = k
    @a = []
    dfs(target.val, -1, 0)
    @a
end

def dfs(cur, pre, len)
    @a << cur if len==@k
    @g[cur].each do |nxt|
        dfs(nxt, cur, len+1) if nxt != pre
    end
end

def build_graph(cur, pre)
    return if cur.nil?

    @g[cur.val] << pre.val if pre
    if cur.left
        @g[cur.val] << cur.left.val
        build_graph(cur.left, cur)
    end
    if cur.right
        @g[cur.val] << cur.right.val
        build_graph(cur.right, cur)
    end
end
