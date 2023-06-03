# @param {Integer} n
# @param {Integer} head_id
# @param {Integer[]} manager
# @param {Integer[]} inform_time
# @param {Integer} n
# @param {Integer} head_id
# @param {Integer[]} manager
# @param {Integer[]} inform_time
# @return {Integer}
def num_of_minutes(n, head_id, manager, inform_time)
  g = (0...n).group_by{|i| manager[i]}

  time = Array.new(n, 0)
  stack = [head_id]
  until stack.empty?
    cur = stack.pop
    g[cur]&.each do |nxt|
      time[nxt] = time[cur]+inform_time[cur]
      stack << nxt
    end
  end

  time.max
end

p num_of_minutes(1, 0, [-1], [0])
p num_of_minutes(6, 2, [2,2,-1,2,2,2], [0,0,1,0,0,0])