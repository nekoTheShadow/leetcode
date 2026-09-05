# frozen_string_literal: true

# @param {Integer[]} nums
# @return {Integer[]}
def result_array(nums)
  a1 = [nums[0]]
  a2 = [nums[1]]
  nums[2..].each do |num|
    if a1[-1] > a2[-1]
      a1 << num
    else
      a2 << num
    end
  end
  a1 + a2
end