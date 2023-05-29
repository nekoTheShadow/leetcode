require './parking_system'
require 'test/unit'

class TestParkingSystem < Test::Unit::TestCase
  def test_example1
    parking_system = ParkingSystem.new(1, 1, 0)
    assert_equal true, parking_system.add_car(1)
    assert_equal true, parking_system.add_car(2)
    assert_equal false, parking_system.add_car(3)
    assert_equal false, parking_system.add_car(1)
  end
end