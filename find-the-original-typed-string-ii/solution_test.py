import unittest

from solution import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_example1(self):
        self.assertEqual(self.solution.possibleStringCount("aabbccdd", 7), 5)

    def test_example2(self):
        self.assertEqual(self.solution.possibleStringCount("aabbccdd", 8), 1)

    def test_example3(self):
        self.assertEqual(self.solution.possibleStringCount("aaabbb", 3), 8)

    def test_ng1(self):
        word = "bbbbbyyyyyyyyyyccccccccyyyqqqqhffffhhhhhhhhsswwwwvvvvvlllldddddddddnnnnnnvr"
        k = 69
        self.assertEqual(self.solution.possibleStringCount(word, k), 23761)
