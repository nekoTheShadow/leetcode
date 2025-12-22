MOD = 10**9 + 7

# @param {Integer[]} complexity
# @return {Integer}
def count_permutations(complexity)
  n = complexity.size
  return 0 if (1..n-1).any?{|i| complexity[0] >= complexity[i]}
  (1..n-1).reduce(1){|acc, c| (acc * c) % MOD}
end

require "minitest/autorun"

describe "3577. Count the Number of Computer Unlocking Permutations" do
  it "Example 1" do
    _(count_permutations([1,2,3])).must_equal 2
  end

  it "Example 2" do
    _(count_permutations([3,3,3,4,4,4])).must_equal 0
  end

  it "NG 1" do
    _(count_permutations([2,68,61])).must_equal 2
  end
end