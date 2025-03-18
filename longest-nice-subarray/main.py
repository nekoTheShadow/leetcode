class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        right = 0
        bit = 0
        max_len = 0
        for left in range(n):
            while right < n and (bit & nums[right]) == 0:
                bit |= nums[right]
                right += 1
            max_len = max(max_len, right - left)
            if left == right:
                right += 1
            else:
                bit &= ~nums[left]
        return max_len
