# @param {Integer[]} nums
# @return {Integer}
def unique_xor_triplets(nums)
  n = nums.size
  n <= 2 ? n : (2 ** nums.max.bit_length)
end
