# @param {Integer[]} nums
# @return {Integer}
def max_sum_div_three(nums)
  total = nums.sum
  mod = total % 3
  if mod == 0
    total
  elsif mod == 1
    ans = 0
    sub1 = nums.filter{|num| num % 3 == 1}.min(1)
    sub2 = nums.filter{|num| num % 3 == 2}.min(2)
    ans = [ans, total - sub1.sum].max if sub1.size == 1
    ans = [ans, total - sub2.sum].max if sub2.size == 2
    ans
  else
    ans = 0
    sub1 = nums.filter{|num| num % 3 == 1}.min(2)
    sub2 = nums.filter{|num| num % 3 == 2}.min(1)
    ans = [ans, total - sub1.sum].max if sub1.size == 2
    ans = [ans, total - sub2.sum].max if sub2.size == 1
    ans
  end
end

require "minitest/autorun"

describe "1262. Greatest Sum Divisible by Three" do
  it "Eample 1" do
    nums = [3,6,5,1,8]
    output = 18
    _(max_sum_div_three(nums)).must_equal output
  end

  it "Eample 2" do
    nums = [4]
    output = 0
    _(max_sum_div_three(nums)).must_equal output
  end
  
  it "Eample 3" do
    nums = [1,2,3,4,4]
    output = 12
    _(max_sum_div_three(nums)).must_equal output
  end
end

