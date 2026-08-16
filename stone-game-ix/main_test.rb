require "minitest/autorun"
require "./main"

describe "2029. Stone Game IX" do
  it "Example 1" do
    _(stone_game_ix([2,1])).must_equal true
  end
  it "Example 2" do
    _(stone_game_ix([2])).must_equal false
  end
  it "Example 3" do
    _(stone_game_ix([5,1,2,4,3])).must_equal false
  end
end