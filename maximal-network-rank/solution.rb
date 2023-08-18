# @param {Integer} n
# @param {Integer[][]} roads
# @return {Integer}
def maximal_network_rank(n, roads)
    s = {}
    roads.each do |a, b|
        s[[a, b]] = true
        s[[b, a]] = true
    end

    d = Array.new(n, 0)
    roads.each do |a, b| 
        d[a] += 1
        d[b] += 1
    end

    max = 0
    (0...n).each do |i|
        (i+1...n).each do |j|
            v = d[i] + d[j]
            v -= 1 if s[[i, j]]
            max = [max, v].max
        end
    end
    max
end
