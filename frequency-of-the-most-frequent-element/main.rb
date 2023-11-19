# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def max_frequency(nums, k)
    nums.sort!
    left = cur = ans = 0

    (0...nums.size).each do |right|
        target = nums[right]
        cur += target
        while (right-left+1)*target-cur > k
            cur -= nums[left]
            left += 1
        end
        ans = [ans, right-left+1].max
    end
    
    ans
end
