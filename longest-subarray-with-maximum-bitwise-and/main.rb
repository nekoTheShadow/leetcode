# @param {Integer[]} nums
# @return {Integer}
def longest_subarray(nums)
    mx = nums.max
    ret = 0
    c = 0
    nums.each do |num|
        if num == mx
            c += 1
        else
            ret = [ret, c].max
            c = 0
        end
    end
    [ret, c].max
end
