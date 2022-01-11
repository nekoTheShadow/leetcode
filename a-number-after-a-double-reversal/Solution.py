import unittest

class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        return num == self.reverse(self.reverse(num))
    
    def reverse(self, num: int) -> bool:
        rev = 0
        while num > 0:
            rev = rev * 10 + (num % 10)
            num //= 10
        return rev


class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertTrue(Solution().isSameAfterReversals(526))
    def test_example2(self):
        self.assertFalse(Solution().isSameAfterReversals(1800))
    def test_example3(self):
        self.assertTrue(Solution().isSameAfterReversals(0))

if __name__ == '__main__':
    unittest.main()