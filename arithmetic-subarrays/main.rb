# @param {Integer[]} nums
# @param {Integer[]} l
# @param {Integer[]} r
# @return {Boolean[]}
def check_arithmetic_subarrays(nums, l, r)
    (0...l.size).map do |i|
        a = nums[l[i]..r[i]].sort
        (0...a.size-1).all?{|j| a[0]-a[1] == a[j]-a[j+1]}
    end
end
