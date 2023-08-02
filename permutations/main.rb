# @param {Integer[]} nums
# @return {Integer[][]}
def permute(nums)
    nums.sort!
    ret = [[*nums]]
    ret << [*nums] while (next_permutation(nums))
    ret
end

def next_permutation(nums)
    n = nums.size
    
    i = n-1
    i-=1 while(i-1>=0 && nums[i-1]>nums[i]) 
    return false if i==0

    j = i
    j+=1 while(j+1<n && nums[i-1]<nums[j+1])
    
    nums[i-1],nums[j] = nums[j],nums[i-1]
    s = i
    t = n-1
    while(s<t)
        nums[s], nums[t] = nums[t], nums[s]
        s += 1
        t -= 1
    end
    return true
end
