# @param {Integer} n
# @param {Integer[][]} reserved_seats
# @return {Integer}
def max_number_of_families(n, reserved_seats)
  g = Hash.new{|h, k| h[k] = []}
  reserved_seats.each do |row, seat|
    g[row] << seat
  end

  tot = 0
  g.each do |row, seats|
    bit = seats.reduce(0){|acc, seat| acc | (1 << seat)}
    tot += counting(bit)
  end
  tot + (n - g.size) * 2
end

BIT2345 = [2, 3, 4, 5].reduce(0){|acc, bit| acc | (1 << bit)}
BIT4567 = [4, 5, 6, 7].reduce(0){|acc, bit| acc | (1 << bit)}
BIT6789 = [6, 7, 8, 9].reduce(0){|acc, bit| acc | (1 << bit)}

# @param {Integer} bit
def counting(bit)
  return 2 if (bit & BIT2345 == 0) && (bit & BIT6789 == 0)
  (bit & BIT2345 == 0) || (bit & BIT4567 == 0) || (bit & BIT6789 == 0) ? 1 : 0
end