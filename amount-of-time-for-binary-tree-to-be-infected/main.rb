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
# @param {Integer} start
# @return {Integer}
def amount_of_time(root, start)
    g = Hash.new{|h, k| h[k] = []}
    build_graph(g, root)

    score = Hash.new{|h, k| h[k] = Float::INFINITY}
    score[start] = 0
    dfs(g, score, start)
    
    score.values.max
end

def build_graph(g, cur)
    if cur.left
        g[cur.val] << cur.left.val
        g[cur.left.val] << cur.val
        build_graph(g, cur.left)
    end
    if cur.right
        g[cur.val] << cur.right.val
        g[cur.right.val] << cur.val
        build_graph(g, cur.right)
    end
end

def dfs(g, score, cur)
    g[cur].each do |nxt|
        if score[cur]+1 < score[nxt] 
            score[nxt] = score[cur]+1
            dfs(g, score, nxt)
        end
    end
end
