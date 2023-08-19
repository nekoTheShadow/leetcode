class UnionFind
  def initialize(n)
    @parents = (0...n).to_a
  end

  def union(x, y)
    x = find(x)
    y = find(y)
    return if x==y
    @parents[x] = y
  end

  def find(x)
    return x if @parents[x]==x
    @parents[x] = find(@parents[x])
    @parents[x] 
  end
end

def find_critical_and_pseudo_critical_edges(n, edges)
  @n = n
  @edges = edges.map.with_index{|(a, b, w), i| [i, a, b, w]}.sort_by{|i, a, b, w| w}

  min_c = kruskal(-1, -1)
  ret = [[], []]
  @edges.each do |i, a, b, w|
    min_c1 = kruskal(-1, i)
    if min_c!=min_c1
      ret[0] << i
    else
      min_c2 = kruskal(i, -1)
      ret[1] << i if min_c2==min_c
    end
  end
  ret
end

def kruskal(force_path, skip_path)
  uf = UnionFind.new(@n)
  c = 0
  @edges.each do |i, a, b, w|
    if i==force_path
      uf.union(a, b)
      c += w
    end
  end
 
  @edges.each do |i, a, b, w|
    next if i==force_path || i==skip_path
    next if uf.find(a) == uf.find(b)
    uf.union(a, b)
    c += w
  end
  c
end

# p find_critical_and_pseudo_critical_edges(5, [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]])
# p find_critical_and_pseudo_critical_edges(4, [[0,1,1],[1,2,1],[2,3,1],[0,3,1]])
p find_critical_and_pseudo_critical_edges(6, [[0,1,1],[1,2,1],[0,2,1],[2,3,4],[3,4,2],[3,5,2],[4,5,2]])
