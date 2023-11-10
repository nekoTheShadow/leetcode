# @param {Integer[][]} adjacent_pairs
# @return {Integer[]}
def restore_array(adjacent_pairs)
    tree = Hash.new{|h, k| h[k] = []}
    adjacent_pairs.each do |x, y|
        tree[x] << y
        tree[y] << x
    end

    root = tree.keys.find{|k| tree[k].size==1}
    ans = [root]
    adjacent_pairs.size.times do
        cur = ans.last
        if tree[cur].size == 1
            ans << tree[cur].first
        else
            x, y = tree[cur]
            ans << y if ans[-2]==x
            ans << x if ans[-2]==y
        end
    end
    ans
end
