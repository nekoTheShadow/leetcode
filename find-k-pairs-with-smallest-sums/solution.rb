# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @param {Integer} k
# @return {Integer[][]}
def k_smallest_pairs(nums1, nums2, k)
    hq = Heapq.new{|(i1, j1), (i2, j2)| nums1[i1]+nums2[j1] <=> nums1[i2]+nums2[j2]}
    nums1.each_with_index do |v, i|
      hq << [i, 0]
    end

    ret = []
    until hq.empty? || ret.size == k
      i, j = hq.pop
      ret << [nums1[i], nums2[j]]
      hq << [i, j+1] if j+1 < nums2.size
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

p k_smallest_pairs([1,7,11], [2,4,6], 3) #=> [[1,2],[1,4],[1,6]]
p k_smallest_pairs([1,1,2], [1,2,3], 2) #=> [[1,1],[1,1]]
p k_smallest_pairs([1,2], [3], 3) #=>[[1,3],[2,3]]