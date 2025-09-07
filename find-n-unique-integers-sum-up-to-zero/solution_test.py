import unittest

from solution import Solution


class SolutionTest(unittest.TestCase):
    def test_property_base(self):
        solution = Solution()
        for n in range(1, 1000 + 1):
            lst = solution.sumZero(n)
            self.assertEqual(len(lst), n)  # 長さがnであること
            self.assertEqual(len(lst), len(set(lst)))  # 要素がuniqueであること
            self.assertEqual(sum(lst), 0)  # 合計が0であること
