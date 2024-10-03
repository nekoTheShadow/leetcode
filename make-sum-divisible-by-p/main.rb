# @param {Integer[]} nums
# @param {Integer} p
# @return {Integer}
def min_subarray(nums, p)
    target = nums.sum % p
    return 0 if target == 0

    n = nums.size
    d = {0 => -1}
    tot = 0
    len = n
    (0...n).each do |i|
        tot = (tot + nums[i]) % p
        x = (tot - target + p) % p
        len = [len, i - d[x]].min if d.key?(x)
        d[tot] = i
    end
    
    len == n ? -1 : len
end
