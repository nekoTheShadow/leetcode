from typing import List
import unittest


class Solution:
    def wordCount(self, startWords: List[str], targetWords: List[str]) -> int:
        import collections
        s = collections.Counter(''.join(sorted(targetWord)) for targetWord in targetWords)
        ans = 0
        for startWord in startWords:
            for ch in 'abcdefghijklmnopqrstuvwxyz':
                if ch in startWord:
                    continue
                word = ''.join(sorted(startWord + ch))
                if word in s:
                    ans += s[word]
                    s[word] = 0
        return ans

class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().wordCount(["ant","act","tack"], ["tack","act","acti"]), 2)

    # def test_example2(self):
    #     self.assertEqual(Solution().wordCount(["ab","a"], ["abc","abcd"]), 1)

if __name__ == '__main__':
    unittest.main()