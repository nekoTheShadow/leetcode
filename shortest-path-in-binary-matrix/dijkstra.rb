class Heapq
  def initialize(&block)
    @heapq = [nil]
    @cmp = block || lambda{ |a,b| a <=> b }
  end

  def push(v)
    @heapq << v
    n = @heapq.size-1
    while n > 1
      break if @cmp.call(@heapq[n/2], @heapq[n]) < 0
      @heapq[n/2],@heapq[n] = @heapq[n],@heapq[n/2]
      n /= 2
    end
  end

  def pop()
    v = @heapq[1]
    @heapq[1] = @heapq[@heapq.size-1]
    @heapq.pop

    n = 1
    while n < @heapq.size
      break if n*2>=@heapq.size
      m = (n*2+1>=@heapq.size || @cmp.call(@heapq[n*2], @heapq[n*2+1])<0) ? n*2 : n*2+1
      break if @cmp.call(@heapq[n], @heapq[m]) < 0
      @heapq[n],@heapq[m] = @heapq[m],@heapq[n]
      n=m
    end
    
    v
  end

  def empty?
    @heapq.size==1
  end

  alias :<< :push
end


# @param {Integer[][]} grid
# @return {Integer}
def shortest_path_binary_matrix(grid)
  return -1 if grid[0][0]==1

  n = grid.length
  costs = Array.new(n){Array.new(n, Float::INFINITY)}
  costs[0][0] = 1

  diffs = [[0,1], [0,-1], [1,0], [1,1], [1,-1], [-1,0], [-1,1], [-1,-1]]
  que = Heapq.new{|a, b| a[:cost] <=> b[:cost]}
  que << {:cost => 1, :x => 0, :y => 0}
  until que.empty?
    top = que.pop
    cost, x, y = top[:cost], top[:x], top[:y]
    break if costs[x][y] < cost

    diffs.each do |dx, dy|
      nx, ny = x+dx, y+dy
      next unless 0<=nx && nx<n && 0<=ny && ny<n && grid[nx][ny]==0 && costs[x][y]+1<costs[nx][ny]
      costs[nx][ny] = costs[x][y] + 1
      que << {:cost => costs[nx][ny], :x => nx, :y => ny}
    end
  end

  costs[n-1][n-1]==Float::INFINITY ? -1 : costs[n-1][n-1]
end

p shortest_path_binary_matrix([[0,1],[1,0]])
p shortest_path_binary_matrix([[0,0,0],[1,1,0],[1,1,0]])
p shortest_path_binary_matrix([[1,0,0],[1,1,0],[1,1,0]])