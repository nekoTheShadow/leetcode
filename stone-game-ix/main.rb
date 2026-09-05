# @param {Integer[]} stones
# @return {Boolean}
def stone_game_ix(stones)
  c = stones.each_with_object([0, 0, 0]){|stone, acc| acc[stone%3]+=1}
  if c[0].even?
    c[1] > 0 && c[2] > 0
  else
    (c[1] - c[2]).abs > 2
  end
end