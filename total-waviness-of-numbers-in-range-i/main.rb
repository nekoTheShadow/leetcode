# @param {Integer} num1
# @param {Integer} num2
# @return {Integer}
def total_waviness(num1, num2)
  (num1..num2).sum do |num|
    num.digits.each_cons(3).count{|(d1, d2, d3)| (d1 < d2 && d2 > d3) || (d1 > d2 && d2 < d3)} 
  end
end

require "minitest/autorun"

describe "3751. Total Waviness of Numbers in Range I" do
  it "Example 1" do
    _(total_waviness(120, 130)).must_equal 3
  end
  it "Example 2" do
    _(total_waviness(198, 202)).must_equal 3
  end
  it "Example 3" do
    _(total_waviness(4848, 4848)).must_equal 2
  end
end