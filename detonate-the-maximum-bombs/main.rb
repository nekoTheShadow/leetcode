require 'set'

# @param {Integer[][]} bombs
# @return {Integer}
def maximum_detonation(bombs)
  n = bombs.size
  g = Array.new(n){Array.new}

  (0...n).each do |i|
    (0...n).each do |j|
      next if i == j

      x1, y1, r1 = bombs[i]
      x2, y2, r2 = bombs[j]
      g[i] << j if (x1-x2)**2 + (y1-y2)**2 <= r1**2 
    end
  end

  ans = 0
  (0...n).each do |start|
    visited = Set[start]
    stack = [start]

    until stack.empty?
      cur = stack.pop
      g[cur].each do |nxt|
        next if visited.include?(nxt)
        visited << nxt
        stack << nxt
      end
    end

    ans = [ans, visited.size].max
  end

  ans
end


p maximum_detonation([[2,1,3],[6,1,4]]) #=> 2
p maximum_detonation([[1,1,5],[10,10,5]]) #=> 1
p maximum_detonation([[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]) #=> 5