# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def maximum_score(nums, k)
    n = nums.size
    l = k
    r = k
    ans = nums[k]
    min = nums[k]

    while l>0 || r<n-1
        if (nums[l-1] || 0) < (nums[r+1] || 0)
            r+=1
            min = [min, nums[r]].min
        else
            l-=1
            min = [min, nums[l]].min
        end

        ans = [ans, min*(r-l+1)].max
    end

    ans
end
