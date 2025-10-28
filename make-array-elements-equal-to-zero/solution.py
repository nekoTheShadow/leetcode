class Solution:
    def countValidSelections(self, nums: list[int]) -> int:
        tot = sum(nums)
        l = 0
        ret = 0
        for num in nums:
            if num == 0:
                r = tot - num - l
                if l == r:
                    ret += 2
                if abs(l - r) == 1:
                    ret += 1
            l += num
        return ret
