# frozen_string_literal: true

require 'minitest/autorun'
require_relative './solution'

describe "Example 1" do
  it "Examlple 1" do
    nums = [3,9,2,1,7]
    k = 3
    output = 7
    _(largest_integer(nums, k)).must_equal output
  end

  it "Examlple 2" do
    nums = [3,9,7,2,1,7]
    k = 4
    output = 3
    _(largest_integer(nums, k)).must_equal output
  end


  it "Examlple 3" do
    nums = [0, 0]
    k = 1
    output = -1
    _(largest_integer(nums, k)).must_equal output
  end
end