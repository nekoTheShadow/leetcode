# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer[]}
def get_averages(nums, k)
    n = nums.size

    # 累積和
    s = Array.new(n+1, 0)
    n.times{|i| s[i+1] = s[i] + nums[i]}

    # [i-k, i+k]の和を求める→[i-k, i+k+1)の和を求める
    ret = Array.new(n)
    n.times do |i|
        x = i-k
        y = i+k+1
        ret[i] = (0<=x&&x<=n)&&(0<=y&&y<=n) ? (s[y]-s[x])/(k*2+1) : -1
    end
    ret

end
