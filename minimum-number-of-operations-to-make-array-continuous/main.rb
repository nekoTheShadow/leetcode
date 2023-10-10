# @param {Integer[]} nums
# @return {Integer}
def min_operations(nums)
    n = nums.size
    ans = nums.size
    nums.uniq!
    nums.sort!

    (0...nums.size).each do |i|
        l = nums[i]
        r = l+n-1
        j = nums.bsearch_index{|v| v > r} || nums.size
        ans = [ans, n-(j-i)].min
    end
    ans
end
