# @param {Integer[]} nums
# @return {Integer}
def longest_subarray(nums)
    return nums.size-1 if nums.all?{|num| num==1}
    return 0 if nums.all?{|num| num==0}

    a = []
    nums.each do |num|
        if num==1
            if a.empty? || a[-1]==0
                a << 1
            else
                a[-1] += 1
            end
        else
            a << 0
        end
    end

    ret = -Float::INFINITY
    a.size.times do |i|
        if a[i] == 0
            v = 0
            v += a[i-1] if 0<=i-1
            v += a[i+1] if i+1<a.size
            ret = [ret, v].max
        else
            ret = [ret, a[i]].max
        end
    end
    ret
end
