import functools
from typing import List

class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        self.nxts = {word : [word[:i]+word[i+1:] for i in range(len(word))] for word in words}
        return max(self.dfs(word) for word in words)

    @functools.lru_cache(maxsize=None)
    def dfs(self, word: str) -> int:
        if not word in self.nxts:
            return 0
        return max(self.dfs(nxt) for nxt in self.nxts[word])+1


if __name__ == '__main__':
    print(Solution().longestStrChain(["a","b","ba","bca","bda","bdca"]))
    print(Solution().longestStrChain(["xbc","pcxbcf","xb","cxbc","pcxbc"]))