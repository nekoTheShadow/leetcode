require 'minitest/autorun'
require_relative './solution'

describe "1386. Cinema Seat Allocation" do
  it "Example 1" do
    n = 3
    reserved_seats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
    _(max_number_of_families(n, reserved_seats)).must_equal 4
  end

  it "Example 2" do
    n = 2
    reserved_seats = [[2,1],[1,8],[2,6]]
    _(max_number_of_families(n, reserved_seats)).must_equal 2
  end

  it "Example 3" do
    n = 4
    reserved_seats = [[4,3],[1,4],[4,6],[1,7]]
    _(max_number_of_families(n, reserved_seats)).must_equal 4
  end
end