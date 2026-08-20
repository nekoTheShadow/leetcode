require 'minitest/autorun'
require_relative './solution'

describe "3069. Distribute Elements Into Two Arrays I" do
  it "Example1" do
    nums = [2,1,3]
    output = [2,3,1]
    _(result_array(nums)).must_equal output
  end

  it "Example2" do
    nums = [5,4,3,8]
    output = [5,3,4,8]
    _(result_array(nums)).must_equal output
  end
end