# @param {Integer[]} nums
# @return {Boolean[]}
def prefixes_div_by5(nums)
  answers = []
  total = 0
  nums.each do |num|
    total = ((total * 2) + num) % 5
    answers << (total == 0)
  end
  answers
end

require "minitest/autorun"

describe "1018. Binary Prefix Divisible By 5" do
  it "Example 1" do
    nums = [0,1,1]
    output = [true,false,false]
    _(prefixes_div_by5(nums)).must_equal output
  end

  it "Example 2" do
    nums = [1,1,1]
    output = [false,false,false]
    _(prefixes_div_by5(nums)).must_equal output
  end
end