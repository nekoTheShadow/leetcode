# @param {Integer[]} nums
# @return {String}
def largest_number(nums)
    s = nums.map(&:to_s).sort{|a, b| b+a <=> a+b}.join
    s =~ /^0+$/ ? "0" : s
end
