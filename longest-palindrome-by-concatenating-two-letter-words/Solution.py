from itertools import count
from typing import List
import unittest


class Solution(object):
    def longestPalindrome(self, words: List[str]) -> int:
        import collections

        counter = collections.defaultdict(int)
        ans = 0
        for word1 in words:
            word2 = word1[1] + word1[0]
            if counter[word2] > 0:
                ans += 2
                counter[word2] -= 1
            else:
                counter[word1] += 1

        if any(word[0] == word[1] and counter[word] > 0 for word in counter):
            ans += 1

        return ans * 2


class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().longestPalindrome(["lc","cl","gg"]), 6)
    def test_example2(self):
        self.assertEqual(Solution().longestPalindrome(["ab","ty","yt","lc","cl","ab"]), 8)
    def test_example3(self):
        self.assertEqual(Solution().longestPalindrome(["cc","ll","xx"]), 2)
    def test_example4(self):
        self.assertEqual(Solution().longestPalindrome(["dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"]), 22)

if __name__ == '__main__':
    unittest.main()