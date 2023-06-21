# @param {Integer[]} nums
# @param {Integer[]} cost
# @return {Integer}
def min_cost(nums, cost)
    @nums = nums
    @costs = cost

    ok = nums.min-1
    ng = nums.max+1
    while (ok-ng).abs > 1
        mi = (ok+ng)/2
        if f(mi-1) > f(mi)
            ok = mi
        else
            ng = mi
        end
    end
    f(ok)
end

def f(x)
    @nums.zip(@costs).sum{|num, cost| (num-x).abs * cost}
end
