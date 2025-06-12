# @param {Integer[]} nums
# @return {Integer}
def max_adjacent_distance(nums) = [*nums, nums[0]].each_cons(2).map{|(a, b)| (a - b).abs}.max
