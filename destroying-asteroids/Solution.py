from typing import List
import unittest

class Solution(object):
    def asteroidsDestroyed(self, mass: int, asteroids: List[int]) -> bool:
        asteroids.sort()
        for asteroid in asteroids:
            if mass < asteroid:
                return False
            mass += asteroid
        return True


class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertTrue(Solution().asteroidsDestroyed(10, [3,9,19,5,21]))

    def test_example2(self):
        self.assertFalse(Solution().asteroidsDestroyed(5, [4,9,23,4]))

    def test_example3(self):
        self.assertTrue(Solution().asteroidsDestroyed(1, [1]))


if __name__ == '__main__':
    unittest.main()