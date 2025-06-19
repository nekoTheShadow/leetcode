# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def partition_array(nums, k)
    count = 0
    min = -Float::INFINITY
    
    nums.sort.each do |num|
        unless num - min <= k
            count += 1
            min = num
        end    
    end
   
    count
end
