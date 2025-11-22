# @param {Integer[]} nums
# @return {Integer}
def minimum_operations(nums)
  nums.count{ _1 % 3 != 0 }
end

require "minitest/autorun"

describe "minimum_operations" do
  it "Example 1" do
    _(minimum_operations([1,2,3,4])).must_equal 3
  end
  it "Example 2" do
    _(minimum_operations([3,6,9])).must_equal 0
  end
end
