# @param {Integer[]} arr
# @param {Integer} difference
# @return {Integer}
def longest_subsequence(arr, difference)
    h = Hash.new{|hash, key| hash[key] = []}
    arr.each_with_index do |v, i|
        h[v] << i
    end

    n = arr.size
    dp = Array.new(n, 0)
    (0...n).each do |i|
        j = h[arr[i]+difference].bsearch{|x| x>i}
        dp[j] = [dp[j], dp[i]+1].max if j
    end

    dp.max+1
end
