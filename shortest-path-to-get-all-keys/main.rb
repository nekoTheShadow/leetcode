# @param {String[]} grid
# @return {Integer}
def shortest_path_all_keys(grid)
  m, n = grid.length, grid[0].length
  start_x, start_y, q = -1, -1, 0
  m.times do |x|
    n.times do |y| 
      start_x, start_y = x, y if grid[x][y]=='@'
      q += 1 if grid[x][y] =~ /[A-Z]/
    end
  end

  que = [[start_x, start_y, 0]]
  cost = Array.new(m){ Array.new(n) { Array.new(2**q, Float::INFINITY) } }
  cost[start_x][start_y][0] = 0
  ret = Float::INFINITY
  until que.empty?
    cur_x, cur_y, bit = que.shift
    if bit == 2**q-1
      ret = [ret, cost[cur_x][cur_y][bit]].min
      next
    end

    [[0, 1], [0, -1], [1, 0], [-1, 0]].each do |dx, dy|
      nxt_x, nxt_y = cur_x+dx, cur_y+dy
      next unless  0<=nxt_x&&nxt_x<m&&0<=nxt_y&&nxt_y<n 
      
      if grid[nxt_x][nxt_y]=='.' || grid[nxt_x][nxt_y]=='@'
        if cost[cur_x][cur_y][bit]+1 < cost[nxt_x][nxt_y][bit]
          cost[nxt_x][nxt_y][bit] = cost[cur_x][cur_y][bit]+1
          que << [nxt_x, nxt_y, bit]
        end
      elsif grid[nxt_x][nxt_y] =~ /[a-z]/
        nxt_bit = bit | (1<<(grid[nxt_x][nxt_y].ord-'a'.ord))
        if cost[cur_x][cur_y][bit]+1 < cost[nxt_x][nxt_y][nxt_bit]
          cost[nxt_x][nxt_y][nxt_bit] = cost[cur_x][cur_y][bit]+1 
          que << [nxt_x, nxt_y, nxt_bit]
        end
      elsif grid[nxt_x][nxt_y] =~ /[A-Z]/
        if bit[grid[nxt_x][nxt_y].ord-'A'.ord]==1 && cost[cur_x][cur_y][bit]+1 < cost[nxt_x][nxt_y][bit]
          cost[nxt_x][nxt_y][bit] = cost[cur_x][cur_y][bit]+1
          que << [nxt_x, nxt_y, bit]
        end
      end
    end
  end

  ret==Float::INFINITY ? -1 : ret
end


p shortest_path_all_keys(["@.a..","###.#","b.A.B"])
p shortest_path_all_keys(["@..aA","..B#.","....b"])
p shortest_path_all_keys(["@Aa"])
p shortest_path_all_keys(["@...a",".###A","b.BCc"])