import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_example1(self):
        eventTime = 5
        k = 1
        startTime = [1, 3]
        endTime = [2, 5]
        output = 2
        self.assertEqual(
            self.solution.maxFreeTime(eventTime, k, startTime, endTime), output
        )

    def test_example2(self):
        eventTime = 10
        k = 1
        startTime = [0, 2, 9]
        endTime = [1, 4, 10]
        output = 6
        self.assertEqual(
            self.solution.maxFreeTime(eventTime, k, startTime, endTime), output
        )

    def test_example3(self):
        eventTime = 5
        k = 2
        startTime = [0, 1, 2, 3, 4]
        endTime = [1, 2, 3, 4, 5]
        output = 0
        self.assertEqual(
            self.solution.maxFreeTime(eventTime, k, startTime, endTime), output
        )
