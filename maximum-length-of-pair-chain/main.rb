# @param {Integer[][]} pairs
# @return {Integer}
def find_longest_chain(pairs)
    pairs.sort!{|(a, b), (c, d)| a==c ? b<=>d : a<=>c}
    n = pairs.size
    dp = Array.new(n, 1)
    (0...n).each do |i|
        a, b = pairs[i]
        (i+1...n).each do |j|
            c, d = pairs[j]
            dp[j] = [dp[j], dp[i]+1].max if b < c
        end
    end
    dp.max
end
