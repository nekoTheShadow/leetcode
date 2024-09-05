# @param {Integer[]} rolls
# @param {Integer} mean
# @param {Integer} n
# @return {Integer[]}
def missing_rolls(rolls, mean, n)
    x = (rolls.size + n) * mean - rolls.sum
    return [] unless 1*n <= x && x <= 6*n

    d, m = x.divmod(n)
    a = [d]*(n-m) + [d+1]*m
end
