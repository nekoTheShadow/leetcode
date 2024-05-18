# @param {TreeNode} root
# @return {Integer}
def distribute_coins(root)
    @move = 0
    dfs(root)
    @move
end

def dfs(cur)
    return 0 if cur.nil?

    l = dfs(cur.left)
    r = dfs(cur.right)
    @move += l.abs + r.abs
    
    (cur.val-1) + l + r
end
