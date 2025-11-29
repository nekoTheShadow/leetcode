# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def max_subarray_sum(nums, k)
  n = nums.size
  
  d = Array.new(n + 1, 0)
  (0...n).each do |i|
    d[i + 1] = d[i] + nums[i]
  end
  
  h = {}
  ret = -Float::INFINITY
  (0..n).each do |i|
    m = i % k
    ret = [ret, d[i] - h[m]].max if h[m]
   
    if h[m]
      h[m] = [h[m], d[i]].min
    else
      h[m] = d[i]
    end
  end 
  
  ret
end


require "minitest/autorun"

describe "3381. Maximum Subarray Sum With Length Divisible by K" do
  it "Example 1" do
    nums = [1,2]
    k = 1
    output = 3
    _(max_subarray_sum(nums, k)).must_equal output
  end
  
  it "Example 2" do
    nums = [-1,-2,-3,-4,-5]
    k = 4
    output = -10
    _(max_subarray_sum(nums, k)).must_equal output
  end

  it "Example 3" do
    nums = [-5,1,2,-3,4]
    k = 2
    output = 4
    _(max_subarray_sum(nums, k)).must_equal output
  end
end