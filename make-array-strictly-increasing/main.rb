# @param {Integer[]} arr1
# @param {Integer[]} arr2
# @return {Integer}
def make_array_increasing(arr1, arr2)
    @arr1 = arr1
    @arr2 = arr2.sort
    @memo = {}
    v = f(-1, 0)
    v == Float::INFINITY ? -1 : v
end

def f(pre, cur)
    key = [pre, cur]
    return 0 if cur == @arr1.length
    return @memo[key] if @memo.key?(key)

    cost = pre < @arr1[cur] ? f(@arr1[cur], cur+1) : Float::INFINITY
    v = @arr2.bsearch{|x| x > pre}
    cost = [cost, f(v, cur+1)+1].min if v
    
    @memo[key] = cost
end
