# frozen_string_literal: true

# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def largest_integer(nums, k)
  d = nums.each_cons(k).flat_map(&:uniq).tally
  d.filter_map{|num, count| num if count == 1}.max || -1
end
