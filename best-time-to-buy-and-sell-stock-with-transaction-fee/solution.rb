# @param {Integer[]} prices
# @param {Integer} fee
# @return {Integer}
def max_profit(prices, fee)
    n = prices.size
    
    # dp[何日目][1なら株を持っている]
    dp = Array.new(n+1){ Array.new(2, -Float::INFINITY) }
    dp[0][0] = 0

    n.times do |i|
        dp[i+1][0] = [dp[i+1][0], dp[i][0]].max # 株を持っていない→何もしない
        dp[i+1][1] = [dp[i+1][1], dp[i][1]].max # 株を持っている→何もしない
        dp[i+1][1] = [dp[i+1][1], dp[i][0]-prices[i]].max # 株を持っていない→株を買う
        dp[i+1][0] = [dp[i+1][0], dp[i][1]+prices[i]-fee].max # 株を持っている→株を売る 
    end

    [dp[n][0], dp[n][1]].max
end
