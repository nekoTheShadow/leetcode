# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def search_range(nums, target)
    x = nums.bsearch_index{|v| v >= target} || nums.size
    y = nums.bsearch_index{|v| v > target} || nums.size  
    (nums[x]==target && nums[y-1]==target) ? [x, y-1] : [-1, -1]
end
