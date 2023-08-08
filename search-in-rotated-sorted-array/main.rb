# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer}
def search(nums, target)
    n = nums.size
    pvt = (0...n).bsearch{|i| nums[i] <= nums.last}
    x = (0...n).bsearch{|i| nums[(i+pvt)%n] >= target}
    return -1 if x.nil?
    nums[(x+pvt)%n]==target ? (x+pvt)%n : -1
end
