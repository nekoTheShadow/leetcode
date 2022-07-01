from typing import List


class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        import operator
        ans = 0
        for numberOfBoxes, numberOfUnitsPerBox in sorted(boxTypes, key=operator.itemgetter(1), reverse=True):
            ans += min(numberOfBoxes, truckSize) * numberOfUnitsPerBox
            truckSize -= min(numberOfBoxes, truckSize)
        return ans


if __name__ == '__main__':
    print(Solution().maximumUnits([[1,3],[2,2],[3,1]], 4))
    print(Solution().maximumUnits([[5,10],[2,5],[4,7],[3,9]], 10))