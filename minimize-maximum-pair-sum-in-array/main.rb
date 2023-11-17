# @param {Integer[]} nums
# @return {Integer}
def min_pair_sum(nums)
    nums.sort!
    n = nums.size
    (0...n/2).map{|i| nums[i]+nums[n-i-1]}.max
end
