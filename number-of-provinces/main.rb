# @param {Integer[][]} is_connected
# @return {Integer}
def find_circle_num(is_connected)
  n = is_connected.size
  a = Array.new(n, -1)
  (0...n).each do |start|
    next if a[start] != -1

    stack = [start]
    until stack.empty?
      cur = stack.pop
      a[cur] = start
      (0...n).each do |nxt|
        next if cur == nxt
        next if a[nxt] != -1
        next if is_connected[cur][nxt] == 0
        stack << nxt
      end
    end
  end

  a.tally.size
end

p find_circle_num([[1,1,0],[1,1,0],[0,0,1]])
p find_circle_num([[1,0,0],[0,1,0],[0,0,1]])