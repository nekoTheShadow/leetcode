# @param {Integer} n
# @param {Integer} k
# @param {Integer} max_pts
# @return {Float}
def new21_game(n, k, max_pts)
  return 1.0 if k==0

  dp = Array.new(n+1, 0.0)
  dp[0] = 1.0

  sum = 1.0
  (1..n).each do |i|
    dp[i] = sum/max_pts
    sum += dp[i] if i < k
    sum -= dp[i-max_pts] if 0 <= i-max_pts && i-max_pts < k
  end

  return dp[k..n].sum
end

p new21_game(10, 1, 10)
p new21_game(6, 1, 10)
p new21_game(21, 17, 10)