# @param {Integer} n
# @param {Integer[]} left_child
# @param {Integer[]} right_child
# @return {Boolean}
def validate_binary_tree_nodes(n, left_child, right_child)
    root = (0...n).find{|i| !left_child.include?(i) && !right_child.include?(i)}
    return false if root.nil?

    seen = [root]
    stack = [root]
    while !stack.empty?
        cur = stack.pop()
        [left_child[cur], right_child[cur]].each do |nxt|
            next if nxt==-1
            return false if seen.include?(nxt)
            stack << nxt
            seen << nxt
        end
    end

    return seen.size == n
end
