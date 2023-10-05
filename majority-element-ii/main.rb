# @param {Integer[]} nums
# @return {Integer[]}
def majority_element(nums)
    n = nums.size
    nums.tally.filter_map{|k, v| k if v > n/3}
end
