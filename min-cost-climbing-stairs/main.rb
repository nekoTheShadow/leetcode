# @param {Integer[]} cost
# @return {Integer}
def min_cost_climbing_stairs(cost)
    n = cost.size
    dp = Array.new(n+1, Float::INFINITY)
    dp[0] = 0
    dp[1] = 0

    (0...n).each do |i|
        dp[i+1] = [dp[i+1], dp[i]+cost[i]].min if i+1<=n
        dp[i+2] = [dp[i+2], dp[i]+cost[i]].min if i+2<=n
    end

    dp[n]
end
