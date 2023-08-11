# @param {Integer} amount
# @param {Integer[]} coins
# @return {Integer}
def change(amount, coins)
    @coins = coins
    @memo = {}
    f(0, amount)
end

def f(x, amount)
    return 1 if amount==0
    return 0 if x==@coins.size

    key = [x, amount]
    return @memo[key] if @memo.key?(key)

    sum = f(x+1, amount)
    sum += f(x, amount-@coins[x]) if amount-@coins[x] >= 0
    @memo[key] = sum
end
