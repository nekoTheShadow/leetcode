# @param {Integer[]} nums
# @return {Integer}
def num_identical_pairs(nums)
    nums.tally.sum{|_, n| n*(n-1)/2}
end
