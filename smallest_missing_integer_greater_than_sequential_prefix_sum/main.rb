# @param {Integer[]} nums
# @return {Integer}
def missing_integer(nums) = (nums.chunk_while{_1+1==_2}.first.sum..).find{!nums.include?(_1)}