
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        ok = -1
        ng = len(nums)
        while abs(ok-ng) > 1:
            mi = (ok+ng)//2
            if nums[mi] <= target:
                ok = mi
            else:
                ng = mi
        return ok if nums[ok] == target else -1


if __name__ == '__main__':
    print(Solution().search([-1,0,3,5,9,12], 9))
    print(Solution().search([-1,0,3,5,9,12], 2))