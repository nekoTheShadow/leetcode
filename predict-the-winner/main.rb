# @param {Integer[]} nums
# @return {Boolean}
def predict_the_winner(nums)
    @nums = nums 
    f0(0, nums.size-1, 0, 0)
end


def f0(l, r, s0, s1)
    return s0>=s1 unless l<=r
    !f1(l+1,r,s0+@nums[l],s1) || !f1(l,r-1,s0+@nums[r],s1)
end

def f1(l, r, s0, s1)
    return s0<s1 unless l<=r
    !f0(l+1,r,s0,s1+@nums[l]) || !f0(l,r-1,s0,s1+@nums[r])
end
