class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        # 能力値をx以下にすることはできるか?
        # → x以下の家がk個以上存在するか?
        def is_ok(x: int) -> bool:
            i = 0
            c = 0
            while i < len(nums):
                if nums[i] <= mi:
                    c += 1
                    i += 2
                else:
                    i += 1
            return k <= c

        ok = max(nums) + 1
        ng = 0
        while abs(ok - ng) > 1:
            mi = (ok + ng) // 2
            if is_ok(mi):
                ok = mi
            else:
                ng = mi

        return ok
