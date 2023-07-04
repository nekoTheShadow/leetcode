# @param {Integer[]} nums
# @return {Integer}
def single_number(nums)
    ret = 0
    32.times do |i|
        s = nums.sum{|num| num[i]}
        s %= 3
        ret |= s<<i
    end
    ret>=2**31 ? ret-2**32 : ret
end
