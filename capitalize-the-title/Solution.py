import unittest

class Solution(object):
    def capitalizeTitle(self, title: str) -> str:
        return ' '.join(s.lower() if len(s) <= 2 else s.capitalize() for s in title.split())

class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().capitalizeTitle("capiTalIze tHe titLe"), "Capitalize The Title")
    def test_example2(self):
        self.assertEqual(Solution().capitalizeTitle("First leTTeR of EACH Word"), "First Letter of Each Word")
    def test_example3(self):
        self.assertEqual(Solution().capitalizeTitle("i lOve leetcode"), "i Love Leetcode")
    def test_example4(self):
        self.assertEqual(Solution().capitalizeTitle("L hV"), "l hv")

if __name__ == '__main__':
    unittest.main()