# @param {Integer[]} nums
# @return {Integer[]}
def get_sum_absolute_differences(nums)
    n = nums.size
    x = 0
    y = nums.sum
    ans = Array.new(n)
    nums.each_with_index do |v, i|
        ans[i] = (v*i-x) + (y-v*(n-i))
        x += v
        y -= v 
    end
    ans
end
