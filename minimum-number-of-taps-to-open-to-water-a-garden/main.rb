# @param {Integer} n
# @param {Integer[]} ranges
# @return {Integer}
def min_taps(n, ranges)
    dp = Array.new(n+1, Float::INFINITY)
    dp[0] = 0
    ranges.each_with_index do |range, i|
        s = [0, i-range].max
        t = [n, i+range].min
        (s..t).each{|j| dp[t] = [dp[t], dp[j]+1].min}
    end
    dp[n]==Float::INFINITY ? -1 : dp[n]
end
