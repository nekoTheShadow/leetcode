from typing import List


class Solution(object):
    def sumOfThree(self, num: int) -> List[int]:
        # a + (a+1) + (a+2) = x
        # a = (x-3)/3
        if (num-3)%3!=0:
            return []
        a = (num-3)//3
        return [a, a+1, a+2]

if __name__ == '__main__':
    print(Solution().sumOfThree(33))
    print(Solution().sumOfThree(4))