# @param {Integer[][]} intervals
# @return {Integer}
def erase_overlap_intervals(intervals)
  n = intervals.size
  intervals.sort!

  dp = Array.new(n+1, 0)
  (0...n).each do |i|
    dp[i+1] = [dp[i+1], dp[i]].max # 何もしない

    s1, e1 = intervals[i]
    j = (i+1...n).bsearch do |x| 
      s2, e2 = intervals[x]
      e1 <= s2
    end
    j = n if j.nil?
    dp[j] = [dp[j], dp[i]+1].max
  end
  n-dp[n]
end
