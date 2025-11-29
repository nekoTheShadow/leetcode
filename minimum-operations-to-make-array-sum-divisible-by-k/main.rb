# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def min_operations(nums, k)
  nums.sum % k
end

require "minitest/autorun"

describe "3512. Minimum Operations to Make Array Sum Divisible by K" do
  it "Example 1" do
     nums = [3,9,7]
     k = 5
     output = 4
     _(min_operations(nums, k)).must_equal output
  end

  it "Example 2" do
     nums = [4,1,3]
     k = 4
     output = 0
     _(min_operations(nums, k)).must_equal output
  end
  
  it "Example 3" do
     nums = [3,2]
     k = 6
     output = 5
     _(min_operations(nums, k)).must_equal output
  end
end