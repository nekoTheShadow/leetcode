# @param {Integer[]} cost
# @param {Integer[]} time
# @return {Integer}
def paint_walls(cost, time)
    n = time.size
    dp = Array.new(n+1){Array.new(n+1, Float::INFINITY)}
    dp[0][0] = 0
    (0...n).each do |i|
        (0..n).each do |j|
            k = [n, j+time[i]+1].min
            dp[i+1][k] = [dp[i+1][k], dp[i][j]+cost[i]].min
            dp[i+1][j] = [dp[i+1][j], dp[i][j]].min
        end
    end
    dp[n][n]
end
