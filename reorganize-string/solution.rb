# @param {String} s
# @return {String}
def reorganize_string(s)
    hq = Heapq.new{|a, b| b[1] <=> a[1]}
    s.chars.tally.each{|w, c| hq << [w, c]}

    t = "@"
    while !hq.empty?
        a = []
        found = false
        while !hq.empty?
          w, c = hq.pop
          if t[-1] == w
            a << [w, c]
          else
            t += w
            hq << [w, c-1] if c > 1
            found = true
            break
          end
        end
        break if !found
        a.each{|w, c| hq << [w, c]}
    end

    s.size==t.size-1 ? t[1..] : "" 
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
