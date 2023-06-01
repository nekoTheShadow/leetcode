# @param {Integer[][]} grid
# @return {Integer}
def shortest_path_binary_matrix(grid)
  return -1 if grid[0][0]==1

  n = grid.length
  cost = Array.new(n){Array.new(n, Float::INFINITY)}
  cost[0][0] = 1

  que = [[0, 0]]
  diffs = [[0,1], [0,-1], [1,0], [1,1], [1,-1], [-1,0], [-1,1], [-1,-1]]
  until que.empty?
    x, y = que.shift
    diffs.each do |dx, dy|
      nx, ny = x+dx, y+dy
      next unless 0<=nx && nx<n && 0<=ny && ny<n && grid[nx][ny]==0 && cost[x][y]+1<cost[nx][ny]
      cost[nx][ny] = cost[x][y] + 1
      que << [nx, ny]
    end
  end

  cost[n-1][n-1]==Float::INFINITY ? -1 : cost[n-1][n-1]
end