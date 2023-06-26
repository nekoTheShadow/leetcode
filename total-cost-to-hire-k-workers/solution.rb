# @param {Integer[]} costs
# @param {Integer} k
# @param {Integer} candidates
# @return {Integer}
def total_cost(costs, k, candidates)
  hq = Heapq.new{|(i1, s1, v1), (i2, s2, v2)| v1==v2 ? i1<=>i2 : v1<=>v2}
  dq = []
  costs.each_with_index do |cost, i|
    if i<candidates
      hq << [i, :head, cost]
    elsif costs.size-candidates<=i
      hq << [i, :tail, cost]
    else
      dq << [i, cost]
    end
  end

  ret = 0
  k.times do
    i1, s1, v1 = hq.pop
    ret += v1
    next if dq.empty?
    
    if s1 == :head
      i2, v2 = dq.shift
      hq << [i2, :head, v2]
    else
      i2, v2 = dq.pop
      hq << [i2, :tail, v2]
    end
  end
  ret
end

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

p total_cost([17,12,10,2,7,2,11,20,8], 3, 4)
p total_cost([1,2,4,1], 3, 3)