# @param {Integer} start
# @param {Integer} goal
# @return {Integer}
def min_bit_flips(start, goal)
    n = [start, goal].map(&:bit_length).max
    (0..n).filter{|i| start[i]!=goal[i]}.count
end
