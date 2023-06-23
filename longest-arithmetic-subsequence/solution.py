import functools, bisect

class Solution:
    def longestArithSeqLength(self, nums):
        n = len(nums)
        ptrs = {}
        for i in range(len(nums)):
            if nums[i] not in ptrs:
                ptrs[nums[i]] = []
            ptrs[nums[i]].append(i)
        
        @functools.lru_cache(None)
        def f(pre, cur):
            nxt_val = nums[cur]+nums[cur]-nums[pre]
            if nxt_val not in ptrs:
                return 2
            
            i = bisect.bisect_right(ptrs[nxt_val], cur)
            if i < len(ptrs[nxt_val]):
                return f(cur, ptrs[nxt_val][i])+1
            else:
                return 2
        
        ret = 0
        for i in range(n):
            for j in range(i+1, n):
                ret = max(ret, f(i, j))
        return ret
