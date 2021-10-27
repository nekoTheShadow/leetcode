import unittest

class Solution:
    def reverse(self, x: int) -> int:
        negative = False
        if x < 0:
            negative = True
            x *= -1

        y = 0
        bound = 2**31
        while x > 0:
            z = x%10
            if (negative and y > (bound-z)//10) or (not negative and y > (bound-1-z)//10):
                return 0

            y = y*10 + z
            x //= 10

        if negative:
            y *= -1

        return y    

class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().reverse(123), 321)
    
    def test_example2(self):
        self.assertEqual(Solution().reverse(-123), -321)
    
    def test_example3(self):
        self.assertEqual(Solution().reverse(120), 21)
    
    def test_example4(self):
        self.assertEqual(Solution().reverse(0), 0)

    def test_wrong(self):
        self.assertEqual(Solution().reverse(1463847412), 2147483641)

        

if __name__ == '__main__':
    unittest.main()
