import re


class Solution:
    def minDeletions(self, s: str) -> int:
        import collections
        p = list(sorted(collections.Counter(s).values(), reverse=True))
        c = 0
        for i in range(len(p)-1):
            if p[i] > p[i+1]:
                continue

            if p[i] == 0:
                c += p[i+1]
                p[i+1] = 0
            else:   
                c += p[i+1]-(p[i]-1)
                p[i+1] = p[i]-1
                
        return c
    
if __name__ == '__main__':
    print(Solution().minDeletions("aab"))
    print(Solution().minDeletions("aaabbbcc"))
    print(Solution().minDeletions("ceabaacb"))
    print(Solution().minDeletions("bbcebab"))