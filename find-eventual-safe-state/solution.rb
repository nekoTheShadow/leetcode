# @param {Integer[][]} graph
# @return {Integer[]}
def eventual_safe_nodes(graph)
  n = graph.size
  r = Array.new(n){ Array.new }
  c = Array.new(n, 0)
  (0...n).each do |i|
    graph[i].each do |j|
      r[j] << i
      c[i] += 1
    end
  end

  q = (0...n).filter{|i| graph[i].empty?}
  a = []
  until q.empty?
    i = q.shift
    a << i
    r[i].each do |j|
      c[j] -= 1
      q << j if c[j] == 0
    end
  end
  a.sort
end

p eventual_safe_nodes([[1,2],[2,3],[5],[0],[5],[],[]])
p eventual_safe_nodes([[1,2,3,4],[1,2],[3,4],[0,4],[]])

