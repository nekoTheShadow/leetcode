# @param {Integer[]} nums
# @param {Integer} k
# @param {Integer[][]} edges
# @return {Integer}
def maximum_value_sum(nums, k, edges)
    @nums = nums
    @k = k
    @memo = {}
    dfs(0, true)
end

def dfs(index, is_even)
    return is_even ? 0 : -Float::INFINITY if index == @nums.size

    key = [index, is_even]
    return @memo[key] if @memo.key?(key)

    a = @nums[index] + dfs(index+1, is_even)
    b = (@nums[index]^@k) + dfs(index+1, !is_even)
    @memo[key] = [a, b].max
    @memo[key]
end
