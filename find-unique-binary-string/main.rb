# @param {String[]} nums
# @return {String}
def find_different_binary_string(nums)
    n = nums.size
    (0..).each do |x|
        d = x.to_s(2).ljust(n, '0')
        return d if !nums.include?(d)
    end
end
