# @param {Integer[]} nums
# @param {Integer} k
# @return {Boolean}
def k_length_apart(nums, k)
  (0...nums.size).filter{|i| nums[i] == 1}.each_cons(2).all?{|i, j| j - i > k}
end

require "minitest/autorun"

describe "k_length_apart" do
  it "example1" do
    nums = [1,0,0,0,1,0,0,1]
    k = 2
    _(k_length_apart(nums, k)).must_equal true
  end

  it "example2" do
    nums = [1,0,0,1,0,1]
    k = 2
    _(k_length_apart(nums, k)).must_equal false
  end
end