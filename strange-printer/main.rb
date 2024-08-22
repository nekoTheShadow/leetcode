# @param {String} s
# @return {Integer}
def strange_printer(s)
    @s = s.squeeze
    @memo = {}
    simulate(0, @s.size-1)
end

def simulate(i, j)
    return 0 if i > j
    return @memo[[i, j]] if @memo.key?([i, j])

    ret = simulate(i, j-1) + 1
    (i...j).each do |k|
        ret = [ret, simulate(i, k-1)+simulate(k, j-1)].min if @s[k] == @s[j]
    end
    @memo[[i, j]] = ret
end
