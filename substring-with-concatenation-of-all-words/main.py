import collections
import functools
from typing import List


class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        n = len(words)
        m = len(words[0])
        ret = []
        for i in range(len(s)-n*m+1):
            d = collections.Counter(words)
            ok = True
            for j in range(len(words)):
                sub = s[i+j*m:i+j*m+m]
                if d[sub] > 0:
                    d[sub] -= 1
                else:
                    ok = False
                    break
            if ok:
                ret.append(i)
        return ret


if __name__ == '__main__':
    print(Solution().findSubstring("barfoothefoobarman", ["foo","bar"]))
    print(Solution().findSubstring("wordgoodgoodgoodbestword", ["word","good","best","word"]))
    print(Solution().findSubstring("barfoofoobarthefoobarman", ["bar","foo","the"]))