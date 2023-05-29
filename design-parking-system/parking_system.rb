class ParkingSystem
  def initialize(big, medium, small)
    @counter = [nil, big, medium, small]
  end

  def add_car(car_type)
    return false if @counter[car_type] == 0
    @counter[car_type] -= 1
    true
  end
end

