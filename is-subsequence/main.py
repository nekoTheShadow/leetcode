class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        ptr = 0
        for c in t:
            if ptr < len(s) and s[ptr] == c:
                ptr += 1
        return ptr == len(s)

if __name__ == '__main__':
    print(Solution().isSubsequence("abc", "ahbgdc"))
    print(Solution().isSubsequence("axc", "ahbgdc"))