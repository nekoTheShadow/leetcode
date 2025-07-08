class Solution:
    def possibleStringCount(self, word: str) -> int:
        n = 0
        ans = 1
        pre = ""

        for cur in word:
            if pre != cur:
                if n > 0:
                    ans += n - 1
                n = 0
            n += 1
            pre = cur

        if n > 0:
            ans += n - 1

        return ans
