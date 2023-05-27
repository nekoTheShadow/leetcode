# @param {Integer[]} stone_value
# @return {String}
def stone_game_iii(stone_value)
  v = Solve.new(stone_value).mini_max(0, 0)
  v > 0 ? "Alice" : (v < 0 ? "Bob" : "Tie")
end


class Solve
  def initialize(stone_value)
    @stone_value = stone_value
    @n = stone_value.length
    @memo = Array.new(@n+1){Array.new(2)}
  end

  def mini_max(cur, player)
    return 0 if @n <= cur
    return @memo[cur][player] if @memo[cur][player]

    if player == 0
      max = -Float::INFINITY
      max = [max, self.mini_max(cur+1, 1-player) + @stone_value[cur]                                            ].max if cur+1<=@n 
      max = [max, self.mini_max(cur+2, 1-player) + @stone_value[cur] + @stone_value[cur+1]                      ].max if cur+2<=@n 
      max = [max, self.mini_max(cur+3, 1-player) + @stone_value[cur] + @stone_value[cur+1] + @stone_value[cur+2]].max if cur+3<=@n 
      @memo[cur][player] = max
    else
      min = Float::INFINITY
      min = [min, self.mini_max(cur+1, 1-player) - @stone_value[cur]                                            ].min if cur+1<=@n 
      min = [min, self.mini_max(cur+2, 1-player) - @stone_value[cur] - @stone_value[cur+1]                      ].min if cur+2<=@n 
      min = [min, self.mini_max(cur+3, 1-player) - @stone_value[cur] - @stone_value[cur+1] - @stone_value[cur+2]].min if cur+3<=@n 
      @memo[cur][player] = min
    end
  end
end

p stone_game_iii [1,2,3,7]
p stone_game_iii [1,2,3,-9]
p stone_game_iii [1,2,3,6]

File.open("testcase") do |f|
  stone_value = f.map{|line| line.chomp.to_i}
  p stone_game_iii stone_value
end